//将用于查询的部分模块化出来

const ArticleSchema = require("../Schema/article");

const {db} = require("../Schema/connectDb");

const Article = db.model("articles",ArticleSchema);

const userSchema = require("../Schema/userSchema");

const User = db.model("users",userSchema);

const CommentSchema = require("../Schema/commentSchema")

const Comment = db.model("comments",CommentSchema);

module.exports = {
    Article,User,Comment
}