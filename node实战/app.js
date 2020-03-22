const Koa = require('koa')
const static = require('koa-static')
const views = require('koa-views')
const router = require('./routers/router')
const logger = require('koa-logger')
const body = require("koa-body");
const { join } = require('path')
const app = new Koa;

let compress = require('koa-compress')
app.use(compress({
  //需要过滤就写上，不写就所有的均不过滤
  // filter: function (content_type) {
  // 	return /text/i.test(content_type)
  // },
  threshold: 0,
  flush: require('zlib').Z_SYNC_FLUSH
}));
///////////////////
const session = require("koa-session");
//这个key是一个数组，如果不写成数组的话，就会报错
app.keys = [" I am a da shuai bi"];

const CONFIG = {
  key:"tao",
  maxAge:86400000,   // session 保存的时间
  overwrite:true,   //是否复写
  httpOnly:true,    //
  signed:true,      //是否签名，如果true，则要声明一个keys，
  rolling:false     // 是否刷新
};

//使用koa-session来记录登录状态
app.use(session(CONFIG,app));
//////////////////


// 注册日志模块
app.use(logger())

//config post data
app.use(body());

// 配置静态资源目录
app.use(static(join(__dirname, "public")))
// 配置视图模板
app.use(views(join(__dirname, "views"), {
  extension: "pug"
}))





// 注册路由信息
app.use(router.routes()).use(router.allowedMethods())

app.listen(9696, () => {
  //console.log("项目启动成功，监听在3000端口")
})



//创建超级管理员
{
  const userSchema = require("./Schema/userSchema");
  const crypto = require("./crypto/crypto")
  const {db} = require("./Schema/connectDb");
  const User = db.model("users",userSchema);

  //查询判断是否存在，
  User
    .find({username:"admin"},(err,data)=>{
      if(err)return;
      //查找到了
      if(data.length){
        console.log("管理员已存在，账号密码均为admin")
      }else{
        //创建admin用户
        new User({
          username:"admin",
          password:crypto("admin"),
          role:666,
          commentNum:0,
          articleNum:0
        })
        .save()
        .then(res=>{
          console.log("创建成功!!");
        })
        .catch(err=>{
          console.log("创建失败!!!");
        })
      }
    })
}
