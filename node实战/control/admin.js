const fs = require("fs");
const {join} = require("path");

//显示后台页面
exports.index = async ctx=>{
    let id = ctx.params.id;

    //动态查询是哪个页面
    const arr = fs.readdirSync(join(__dirname , "../views/admin"));
    //在循环里面使用异步不太好，所以我们得用一个标志值来表示，如果有匹配的，那么就将标志值变为true，表示匹配上了。
    let bool = false;
    arr.forEach(v =>{
        const name = v.replace(/^(admin\-)|(\.pug)$/g,"");
        console.log("gg");
        console.log(name);
        if( name === id){
            bool = true;
            return;
        }
    })
    console.log(id);
    console.log(ctx.session.role , 999);
    if(bool){
        await ctx.render("./admin/admin-"+ id,{
            title:id,
            role:ctx.session.role
        })
    }
}


//头像上传

