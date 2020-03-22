

const multer = require('koa-multer');//加载koa-multer模块

const { join } = require("path");
//文件上传
//配置
let storage = multer.diskStorage({
  //文件保存路径
  destination:join(__dirname , "../public/avatar"),
  //修改文件名称
  filename: function (req, file, cb) {
    let fileFormat = (file.originalname).split(".");
    cb(null,Date.now() + "." + fileFormat[fileFormat.length - 1]);
  }
})
//加载配置
let upload = multer({ storage: storage });

module.exports = upload;
