const { Article,User,Comment} = require("../Model/main")

exports.writeArticle = async ctx=>{
    await ctx.render("add-article",{
        session:ctx.session
    })
}

//发表文章
exports.write = async ctx=>{
    //没有登录
    if(ctx.session.isNew){
        return ctx.body = {
            msg:"用户未登录"
        }
    }
    //登录了，则将数据放到数据库里面
    const data = ctx.request.body;
    //author应该是一个objectId
    data.author = ctx.session.uid;
    data.commentNum = 0;
    console.log(data);
    await new Promise((resolve,reject) => {
        new Article(data).save((err,data)=>{
            if(err) return reject(err);

            //发表了文章，就让用户文章的数量加一
            User.update({_id:data.author},{$inc:{articleNum:1}},(err)=>{
                if(err) return console.log("出错了");
                console.log("修改成功");
            })
            resolve(data);
        })
    })
    .then(res=>{
        console.log(res,"res");
        ctx.body = {
            msg:"保存成功",
            status:1
        }
    })
    .catch(err=>{
        ctx.body = {
            msg:"保存失败",
            status:0
        }
    })

}


exports.page  = async ctx=>{

    //首先获取到id值，也就是第几页的id值,如果是第一页，则默认为1
    let id = ctx.params.id || 1;
    id--;
    const maxNum = await Article.estimatedDocumentCount((err,data)=>{
        console.log(data);
        return data;
    });
    const artList = await Article
        .find()
        //对时间降序排列
        .sort("-created")
        //跳过多少条
        .skip(2*id)
        //限制每一页多少条
        .limit(2)
        //实现连表查询
        .populate({
            //查询哪张表，因为在users里面的author里面已经配置好了，
            path:"author",
            //查询什么属性
            select:"_id username avatar"
        })
        .then(res=>res)
        .catch(err=>err)
    //console.log(artList,666);
    await ctx.render("index",{
        title:"实战博客首页",
        session:ctx.session,
        artList,
        maxNum
    })
}

exports.all = async ctx=>{
    const uid = ctx.session.uid;
    await Article.find({author:uid})
        .then(res=>{
            ctx.body = {
                code:0,
                count:5,
                data:res
            }
        })
}

//删除文章
exports.delete = async ctx=>{
    //获取文章id
    const id = ctx.params.id;
    let res = {
        state:1,
        message:"删除成功"
    }

    await Article.find({_id:id}).then(res=>{
        //这个地方就类似于删除掉了文章本身
        res.forEach(v=>v.remove());
    })
    .catch(err=>{
        res = {
            state:0,
            message:"删除失败"
        }
    })
    ctx.body = res;

    // //用户id
    // const uid = ctx.session.uid;
    // const fromId = [];
    
    // //当前用户的文章数减一
    // await User.update({_id:uid},{$inc:{articleNum:-1}})


    // //先找到每一条评论，将其作者的commentNum减一，
    // //再删除所有的评论
    // await Comment.find({article:id}).then(res=>{
    //     //寻找作者
    //     //const userId = res.from;
    //     const len = res.length;
    //     let i = 0;
    //     async function deletes(){
    //         if(i>len) return;
    //         console.log("开始更新用户的评论数");
    //         await User.update({_id:res[i].from},{$inc:{commentNum:-1}}).then(res=>{
    //             i++;
    //             console.log("更新完成");
    //         });
    //     }
    //     deletes();
    // });

    // await Comment.deleteMany({article:id});
    // await Article.deleteOne({_id:id}).then(res=>{
    //     console.log("删除文章成功 ");
    //     ctx.body = {
    //         state:1,
    //         message:"成功"
    //     }
    // })
    // .catch(err=>{
    //     ctx.body = {
    //         state:0,
    //         message:"失败"
    //     }
    // })
    

}





