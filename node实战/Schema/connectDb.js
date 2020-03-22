const mongoose = require("mongoose");

const db = mongoose.createConnection("mongodb://47.96.117.199:27017/blogProject",{
    useNewUrlParser:true
})

//使用es6的promise
mongoose.Promise = global.Promise;

//监听是否成功
db.on("error",function(){
    console.log("connection error");
});

db.on("open",function(){
    console.log("connection success!!");
});

const Schema = mongoose.Schema;

module.exports = {
    db,Schema
}