const {Schema} = require("./connectDb");
//console.log(Schema.Types);
const ObjectId = Schema.Types.ObjectId

const ArticleSchema = new Schema({
    author:{
        //这个id就是users里面每一个用户的_id值
        type:ObjectId,
        //这里表示是连表查询，查询的是users
        ref:"users"
    },
    tips:String,
    title:String,
    content:String,
    commentNum:Number
},{
    versionKey:false,
    timestamps:{
        //加这个是为了排序，用创建的时间进行排序，后面的属性值是这个时间在数据中的属性名。
        createdAt:"created",
        updatedAt:"update"
    }
});

ArticleSchema.post("remove",(doc) => {
    const {User,Comment} = require("../Model/main");

    //评论者评论数量 -1  + 删除所有的评论
    Comment.find({article:doc._id}).then(res=>{
        //这个使用commentSchema里面的内容
        res.forEach(v=>v.remove());
    });
})


module.exports = ArticleSchema;