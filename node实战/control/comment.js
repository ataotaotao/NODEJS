const { Article,User,Comment} = require("../Model/main")


//查找文章详情以及评论详情
exports.details = async ctx=>{
    //获取到_id值，
    const _id = ctx.params.id;

    //查找文章详情
    const article = await Article
        .findById(_id)
        .populate({
            path:"author",
            select:"username"
        })
        .then(res=>res)
        .catch(err=>err);
    //查找评论详情
    //console.log(article);
    const comment = await Comment
        .find({article:_id})
        .sort("-created")
        .populate("from","username avatar")
        .then(res=>res)
        .catch(err=>{
            console.log(err);
        });
    //console.log(comment);

    await ctx.render("article",{
        title:"article详情页",
        session:ctx.session,
        article,
        comment
    })
};


//评论
exports.reply = async ctx=>{

    if(ctx.session.isNew){
        ctx.body = {
            status:0,
            msg:"用户未登录"
        };
    }
    const data = ctx.request.body;

    data.from = ctx.session.uid;

    const comment = new Comment(data);

    await comment.save()
        .then(res=>{
            ctx.body = {
                status:1,
                msg:"评论成功"
            }

            //评论成功之后在当前用户的评论数里面加一
            User.update({_id:data.from},{$inc:{commentNum:1}},(err,data)=>{
                console.log("评论数量加一");
            })


            //评论成功，在数据库里面的评论数量加一
            Article
                .update({_id:data.article},{$inc:{commentNum:1}},(err)=>{
                    if(err) return console.log(err);
                    console.log("原子操作成功");
                })

        })
        .catch(err=>{
            ctx.body = {
                status:0,
                msg:"评论失败"
            }
        })

}

//获取到评论
exports.back = async ctx=>{
    //先获取到数据
    const uid = ctx.session.uid;
    await Comment
        .find({from:uid})
        .populate({
            path:"article",
            select:"title"
        })
        .then(res=>{
            //表格数据返回有格式要求
           ctx.body = {
               code:0,
               count:5,
               data:res
           }
        });
    // console.log(data);
    // ctx.body = data;
}

//删除评论
exports.del = async ctx=>{
    //先获取到id值
    const commentId = ctx.params.id;
    let res = {
        state:1,
        message:"删除评论成功"
    };
    await Comment.find({_id:commentId}).then(res=>{
        res.forEach(v=>v.remove());
    })
    .catch(err=>{
        res = {
            state:0,
            message:"删除评论失败"
        }
    })
    ctx.body = res;



    // let articleId = "";
    // await Comment.findById(commentId)
    //     .then(res=>{
    //         articleId = res.article;
            
    //     });
    // await User.update({_id:uid},{$inc:{commentNum: -1}});

    // //评论自身删除掉
    // await Comment.deleteOne({_id:commentId});

    // await Article.update({_id:articleId},{$inc:{commentNum: -1}})
    //     .then(res=>{
    //         ctx.body = {
    //             state:1,
    //             message:"删除成功"
    //         }
    //     });
    
    
}

