const Router = require('koa-router')
const router = new Router
const user = require("../control/user");
const article = require("../control/article");
const comment = require("../control/comment")
const admin = require("../control/admin");

const upload = require("../crypto/upload");

// 设计主页  
router.get("/", user.keepLog , article.page)
// 主要用来处理  用户登录 用户注册
router.get(/^\/user\/(?=reg|login)/, async (ctx) => {
  // show 为 true 则显示注册   false 显示登录
  const show = /reg$/.test(ctx.path)

  await ctx.render("register", {show})
})


//注册功能
router.post("/user/reg",user.reg);

//登录功能
router.post("/user/login",user.login)

//退出功能
router.get("/user/logout",user.logout);


//发表文章页
router.get("/article", user.keepLog ,article.writeArticle)

router.post("/article",user.keepLog , article.write);

//使用路由来控制第几页，
router.get("/page/:id",article.page);

//文章详情页
router.get("/article/:id", user.keepLog ,comment.details)


//点击回复按钮
router.post("/comment",user.keepLog,comment.reply)

//个人中心
router.get("/admin/:id",admin.index);


// 头像
router.post("/upload", user.keepLog , upload.single('file') , user.upload)

//后台请求评论返回数据
router.get("/user/comments",user.keepLog , comment.back)

// 删除评论操作
router.delete("/comment/:id",user.keepLog , comment.del);

//文章分类返回
router.get("/user/articles",user.keepLog , article.all)

//文章删除
router.delete("/article/:id",user.keepLog , article.delete)

//用户信息返回
router.get("/user/users",user.keepLog , user.infos);

//删除某一个用户
router.delete("/user/:id",user.keepLog , user.deletes)

//404页面
router.get("*",async ctx=>{
  await ctx.render("404",{
    title:"404"
  });
})

module.exports = router