const { Article,User,Comment} = require("../Model/main")

const crypto = require("../crypto/crypto")

const upload = require("../crypto/upload");

//这个地方传入的第一个参数的重要作用之一就是用来连表查询。传入这个参数表示
//就是连表查询

exports.reg = async ctx=>{
    //获取到form表单传递来的username和password
    //get username and password passed by form
    const user = ctx.request.body;
    const username = user.username;
    const password = user.password;

    //query database to confirm whether the username exists in database
   await new Promise((resolve,reject) => {
       User.find({username},(err,data)=>{
           if(err) return reject(err);
           
           if(data.length){
               return resolve("")
           }
           let users = new User({
                username,
                password:crypto(password),
                articleNum:0,
                commentNum:0
            });
            users.save((err,data) =>{
                if(err){
                    reject(err);
                }else{
                    resolve(data);
                }
            });
       })
   })
   .then(async res=>{
       if(res){
            await ctx.render("isOk",{
                status:"注册成功"
            })
       }else{
            await ctx.render("isOk",{
                status:"用户已经注册过了"
            })
       }
        
   }).
   catch( async err=>{
        await ctx.render("isOk",{
            status:"注册失败"
        })
   })

};

exports.login = async ctx => {
    const user = ctx.request.body;
    const username = user.username;
    const password = user.password;
    await new Promise((resolve,reject) => {
        User.find({username},(err,data)=>{
            if(err) return reject(err);
            if(!data.length){
                resolve("");
            }
            //coming here,it seems that your username has checked,but I will check your password as well
            if(data[0] && data[0].password === crypto(password)){
                resolve(data[0]);
            }
        })
    })
    .then( async res=>{
        if(res){
            //console.log(1);
            //在登录成功之前设置session和cookie信息，告诉前端，以及后端记录
            //前端设置cookie

            
            
            
            //console.log(res);
            //这里面必须加signed，否则会报错。
            ctx.cookies.set("username",username,{
                domain:"47.96.118.199",   // 告诉访问的当前主机
                path:"/",   //在根目录下设置会让所有的页面都有cookie信息
                maxAge:864000 , // 最长保存时间
                httpOnly:true,   //设置为true的话，前端就不可见了，
                overwrite:false,
                signed:false    ////是否在前端为每一个cookie加一个为sig的cookie
            });

            ctx.cookies.set("uid",res._id,{
                domain:"47.96.118.199",   // 告诉访问的当前主机
                path:"/",   //在根目录下设置会让所有的页面都有cookie信息
                maxAge:864000 , // 最长保存时间
                httpOnly:true,   //设置为true的话，前端就不可见了，
                overwrite:false,
                signed:false
            });

            //后端设置session
            ctx.session = {
                username,
                uid:res._id,
                //在users数据库里面设置好用户头像，以便于在查询页面内容的时候使用。
                avatar:res.avatar,
                role:res.role
            };

            await ctx.render("isOk",{
                status: "登录成功"
            });
        }else{
            await ctx.render("isOk",{
                status: "用户未注册"
            });
        }
    },async res=>{
        await ctx.render("isOk",{
            status: "登录失败"
        });
    
    })



}

//保持登录状态。
exports.keepLog = async (ctx,next)=>{
    //排除一种情况，session已经消失了，但是cookie还在，
    //为了让两者同步，一般设置cookie时间比session时间长一些。
    //isNew用来判断是不是为新的内容
    if(ctx.session.isNew){
        if(ctx.cookies.get("username")){
            ctx.session = {
                username:ctx.cookies.get("username"),
                uid:ctx.cookies.get("uid")
            }
        }
    }
    //之后执行下一个中间件
    await next();
}


exports.logout = async ctx=>{
    ctx.session = null;
    ctx.cookies.set("username",null,{
        maxAge:0
    });
    ctx.cookies.set("uid",null,{
        maxAge:0
    });
    ctx.redirect("/");
}




//用户上传头像
exports.upload = async ctx =>{
    //console.log(ctx.req);
    const filename = ctx.req.file.filename;
    let data = {};
    await User.update({_id:ctx.session.uid},{$set:{avatar:"/avatar/"+filename}},(err,data)=>{
        if(err){
            data = {
                status:0,
                message:"上传失败"
            };
        }else{
            data={
                status:1,
                message:"上传成功"
            }
        }
        ctx.session.avatar = "/avatar/"+filename;
        ctx.body = data;
    });
    


}

//用户信息返回
exports.infos = async ctx=>{
    await User.find({}).then(res=>{
        //排除管理员
        res.forEach((item,index)=>{
            if(item.username === "admin"){
                res.splice(index,1);
            }
        })
        console.log(res);
        ctx.body = {
            code:0,
            count:5,
            data:res
        }
    })
    .catch(err=>{
        console.log(err);
    })
}

//管理员删除某一个用户
exports.deletes = async ctx=>{
    
    const _id = ctx.params.id;
    
    const res = {
        state:1,
        message:"删除用户成功"
    };

    await User.find({_id}).then(res=>{
        res.forEach(v=>v.remove());
    })
    .catch(err=>{
        res = {
            state:0,
            message:"删除用户失败"
        }
    });
    ctx.body = res;

    // let ress = {};
    // //删除用户对别人的评论
    // await Comment.deleteMany({from:uid}).then(res=>{
    //     console.log("删除对别人的评论成功");
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"删除对别人的评论失败"
    //     }
    // });
    // //删除所有的文章.
    // //这里面处理好了：用户的评论数量-1
    // await Article.find({author:uid}).then(res=>{
    //     //console.log(res,666666);
    //     let i = 0;
    //     //因为res是一个数组，所以得多次执行
    //     //寻找所有的评论作者，将其commentNum - 1
    //     async function findAll(){
    //         if(i>res.length) return;
    //         //删除当前文章的评论
    //         //首先通过评论找到作者
    //         //然后改变作者的commentNum;
    //         await Comment.find({article : res[i]._id}).then( res=>{
    //             //res就是找到的评论者的信息;
    //             let j = 0;
    //             async function userless(){
    //                 if(j>res.length) return;
    //                 await User.update({_id:res[j].from},{$inc:{commentNum:-1}}).then(res=>{
    //                     console.log("用户成功");
    //                     j++;
    //                 })
    //             }
    //             userless();
    //         });
    //         i++;
    //     }
    //     findAll();
    //     console.log("调整别人对自己文章的评论成功")
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"调整别人对自己文章的评论失败"
    //     }
    // });
    // //删除文章所有的评论:
    // await Article.find({author:uid}).then(res=>{
    //     console.log(res,"gggg")
    //     let i = 0;
    //     async function deleteM(){
    //         if(i>res.length) return;
    //         await Comment.deleteMany({article:res[i]._id}).then(res=>{
    //             i++;
    //         })
    //     }
    //     deleteM();
    //     console.log("删除文章的评论成功")
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"删除文章的评论失败"
    //     }

    // });

    // //删除文章
    // await Article.deleteMany({author:uid}).then(res=>{
    //     console.log("删除文章成功")
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"删除文章失败"
    //     }
    // });

    // //删除用户自身
    // await User.deleteOne({_id:uid}).then(res=>{
    //     console.log("删除用户成功");
    //     ctx.body = {
    //         state:1,
    //         message:"删除用户成功"
    //     }
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"删除用户失败"
    //     }
    // });

    
}



