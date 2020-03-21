# `php`字符串

## 一、字符串变量

一般用于存储并处理文本

创建字符串：

```php
<?php
	$str = "hello world";
	echo $str;
```

### 1、PHP拼接运算符

`.`

这个拼接运算符和JS里面的+运算符相同

```php
<?php
	$str = "hello world";
	$str2 = "my friends";
	echo $str."!! ".$str2;
```

### 2、字符串长度函数   `strlen()`

```php
<?php
	$str = "hello world";
	$a = strlen($str);
	echo $a;//11
```

这个函数常用于循环以及其他函数，用于获取到循环的长度，以及何时结束

```php
for($i = 0;$i<strlen($str);$i++){
    echo $i;
}
```

这个可以输出从0到字符串长度的内容

这个方式在计算中文字符的时候，一个中文占3个字符数

可以使用`mb_strlen()`方法来设置指定编码输出中文字符个数：

`$a = mb_strlen("我的名字","utf-8");`

输出4

### 3、返回查找的字符首次出现位置的函数  `strpos()`

这个函数用于在字符串内容查找一个字符或者一段指定的文本，找打了返回首次出现的位置，如果没匹配到返回FALSE

用法：`strpos(要查找的字符串，匹配的字符串)`

```php
<?php
	$str = "hello world";
	echo strpos($str,"llo");
```

这个返回的不是第一个匹配的字符的下标，是按照字符数量来计算的。中文在不同的字符编码下面都不同，所以这个方法***只能用来判断字符是否存在***

