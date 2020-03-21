# `webpack `使用

	## 1、安装`webpack`

 + 首先安装node
 + node安装完了之后可以使用`node -v`来查看node的版本号，同时`node`里面自带了`npm`，所以可以用`npm -v`来查看`npm`的版本号
 + 如果`npm`太慢了，可以使用国内的淘宝镜像，上百度搜索淘宝镜像，`https://npm.taobao.org/`,然后在命令行里面输入：`npm install -g cnpm --registry=https://registry.npm.taobao.org`,这个表示安装`cnpm`，装好了之后使用`cnpm -v`来查看它的版本。
 + 安装`webpack`，下载好了`cnpm`之后下载`webpack` ，命令：`npm install -g webpack`,里面的`npm` 可以换成是`cnpm`,等待一段时间之后就下载好了，然后使用`webpack -v`就可以查看`webpack`的版本。
 + 但是，有时候会出现一个问题：`npm install -g cnpm --registry=https://registry.npm.taobao.org` ,说我们还需要安装一个`webpack-cli`，那么我们输入命令：`npm webpack-cli -g`，就可以装好这个，然后再输入`webpack -v`，就可以看到版本号了

## 2、使用`webpack`初始化一个项目

 + 首先使用命令行在相关位置创建一个`webpack`文件夹

 + 注意：我们创建的文件夹的名字默认就会作为我们的项目的名字，所以我们的项目名字不能和我们的模块名字冲突了，否则在初始化的时候会报错

 + 之后进入这个文件夹           `cd 文件夹`

 + 之后还要再安装一次`webpack`,原因：可能上线之后我们的环境里面没有`webpack`，所以我们要再下载一次

 + 接下来是安装`webpack`命令，例如：`cnpm i --save webpack`,在这里面，`--save`还有另外一个，`--save-dev`，--save表示我们后面的这个模块，是在上线的时候要用到的，而`--save-dev`则只是在本地开发项目的时候用得到。简写：`--save`可以简写为 -S， `--save-dev`可以简写做：`-D` .

 + 之后再文件夹里面会多一个node_modules文件，那么这个项目所有依赖的模块都在这个文件夹里面了。而在上线的时候可以不用上传

 + 之后在`helloworld`里面创建一个`src`文件夹，然后将我们要编译的文件放在里面。

 + 在`helloworld`根目录下面创建一个配置文件(js文件)，开启配置工作。

 + 配置中写入：

   ```js
   const path = require("path");
   module.exports = {
       entry:"./src/app.js",
       output:{
           path:path.resolve(__dirname,"dist"),
           filename:"app.bundle.js"
       }
   };
   ```

+ 这些代码表示入口为app.js，然后出口在`dist`文件夹下面的`app.bundle.js`

+ 之后在命令行里面输入`webpack`，就可以对文件进行编译，最后出现的结果里面提示我们没有对mode进行编译，development还是production。

+ 在文件夹里面，多增加了一个`dist`文件夹，也就是我们的出口路径，里面有output里面的filename文件。

+ 打开这个`js`文件，发现是刚才的app.bundle.js文件，打开`js`文件，发现里面多了很多的`js`代码，这些`js`代码是`webpack`给我们加上的。只有在最后有一个我们写入的代码，

+ 此时看到的`js`文件是被压缩过的，我们在上线的时候才需要这种类型的文件，我们在本地需要去读取代码，所以不需要这种文件。

+ 接下来就是对这个文件进行解压缩，变为正常模式，

+ 回到根目录下，输入 `webpack -d`,那么文件就会被解压缩。

+ 测试这个项目是否可以运行：输入`node 这个js文件`,如果返回了想要的结果，就说明`webpack`可以运行了。

  ### 注意：在`linux`环境下操作过程也基本类似，不同之处只是一些命令的不同

## 3、以我创建的一个文件夹为例

+ 首先打开命令行，打开桌面，                   `cd Desktop`
+ 然后在桌面上创建一个文件夹，               `md helloworld`
+ 之后进入这个文件夹                                   `cd helloworld`
+ 然后初始化                                                   `npm init`
+ 之后一路回车，此时我们打开文件夹，就会发现有一个`json`的文件夹
+ 里面是刚才的一些配置参数.
+ 因为这个项目时要在上线用到的，所以输入命令`cnpm i -S webpack`,
+ 之后创建一个`src`文件夹，然后将我们要编译的文件放在里面，创建一个`js`文件，随意写入一个指令
+ 在`helloworld`根目录下面创建一个配置文件        cd >webpack.config.js 
+ 写入上面的代码，然后命令行里面执行`webpack`。
+ 之后生成的`dist`文件夹里面有我们的app.bundle.js文件，
+ 退回到根目录下，输入命令解压缩这个app.bundle.js，命令：`webpack -d`
+ 之后测试`js`文件是否可以运行，`node app.bundle.js`
+ 输入命令，返回相应的结果。

## 4、`webpack`注意点

 + mode
   + 一共有两种模式，一种是生产者模式，一种是开发者模式，
   + 我们上面采用的 `webpack -d` 就是开发者模式，就是将文件解压掉，然后还有另外一种模式，`webpack -p`，就是生产者模式，生产者模式追求最小体积，所以代码是压缩的，开发者模式则追求代码，所以代码没有压缩。
   + 我们可以通过两个命令在两种模式之间转化
+ 一些注意点：
  + 首先是我们采用上面的模式进行编译，如果在`app.js`文件里面改变了一些内容，我们还得用 `webpack -d`或者 `webpack -p`来进行编译，十分的麻烦。
  + 我们可以在这个的基础上进行监听，那么修改了entry的文件之后，就不用再输入指令了，output的文件也会随之改变。命令：`webpack -d --watch`或者 `webpack -p --watch`
  + 采用上面的命令之后，对entry里面的文件进行编译保存后，在命令行里面就会出现一个修改之后的信息，同时，打包后的js文件也会出现相应的修改。
  + 退出监听模式 `ctrl + c` 
+ 配置文件里面的模式选定
  + 在刚开始配置模式的时候，我们可以指定我们编译后的文件是哪种模式。
  + 在output里面写入：`mode: 模式`，模式可以是 `development`或者 `production` 
  + 在指定了之后我们在前面的 `webpack -d`就不用再输入`-d`了，只需输入 `webpack` 即可。

`linux下面，mv命令用于重命名`

## 插件使用

### 1、整合资源，通常我们会通过引用将一个JS文件放在一个html里面，平时我们会通过手写的方式进行

但是我们可以采用一个插件来搞定，`html-webpack-plugin`,

### 使用步骤：

##### 1、安装

```js
npm/cnpm install -D/S html-webpack-plugin
```

###### 2、引入

```js
	//在webpack.config.js里面写入：
	cosnt htmlWebpack = require("html-webpack-plugin");
```



