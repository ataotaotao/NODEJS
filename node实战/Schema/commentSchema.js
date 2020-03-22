const {Schema} = require("./connectDb");
const ObjectId = Schema.Types.ObjectId;


const CommentSchema = new Schema({
    content:String,
    article:{
        type:ObjectId,
        ref:"articles"
    },
    from:{
        type:ObjectId,
        ref:"users"
    }
},{
    versionKey:false,
    timestamps:{
        //加这个是为了排序，用创建的时间进行排序，后面的属性值是这个时间在数据中的属性名。
        createdAt:"created",
        updatedAt:"update"
    }
});

// .pre 是在之前运行， .post是在钩子之后运行，但是都是在事件之前执行，
// pre 里面的this表示前面的数据，json，在post里面回调参数就是数据。

CommentSchema.post("remove",(doc)=>{
    //在这里面调用
    const {User,Article} = require("../Model/main");

    //接收到数据
    const {article,from} = doc;
    Article.findByIdAndUpdate(article , {$inc:{commentNum: -1 }}).exec();

    //用户评论数减一
    User.findByIdAndUpdate(from,{$inc:{commentNum:-1}}).exec();

})

module.exports = CommentSchema;