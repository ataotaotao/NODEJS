# 常量

## 一、常量是一个简单的标识符，该值在脚本中不能改变。

##### 由英文字母，下划线，数字组成，但是数字不能为首字母。常量不需要$修饰，变量才需要

常量在整个脚本中都可以使用

##### 设置常量，使用defined函数

如：

```php
bool define( string $name,mixed $value , [bool $case_insensitive = false])
```

三个参数：

 + name，必选参数，常量名称
 + value，必选参数，常量的值
 + 第三个参数，可选参数，设置为true，表示对大小写不敏感。默认false

实例：

```php
<?php
	define("names","helloworld",false);
	echo names; 
	//注意：这里面定义的时候names要加引号
```

不区分大小写的变量名

实例：

```php
<?php
    defined("names","helloworld",true);
	echo names;
	//同样可以辨识出来
```

## 二、常量是全局的

常量在定义之后，默认是全局变量，可以在真个运行的脚本的任何地方使用。

下面的例子表示在函数里面使用常量

```php
<?php
    define("names",1,false);
    function fn(){
        echo names;
    }
    fn();
```









