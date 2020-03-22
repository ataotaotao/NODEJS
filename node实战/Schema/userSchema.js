const {Schema} = require("./connectDb");

const userSchema = new Schema({
    username:String,
    password:String,
    //给每一个用户指定一个默认的头像为初始头像。
    avatar:{
        type:String,
        default:"/img/1.jpg"
    },
    articleNum:{
        type:Number,
        defalut:0
    },
    commentNum:{
        type:Number,
        defalut:0
    },
    role:{
        type:Number,
        default:0
    }
},{
    versionKey:false
});

userSchema.post("remove",(doc) => {
    const {Article,User} = require("../Model/main");

    const {_id} = doc;

    Article.find({author:_id}).then(res=>{
        res.forEach(v=>v.remove());
    })
})

module.exports = userSchema;