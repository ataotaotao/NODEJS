# echo 和print的区别

##### echo可以输出一个或多个字符串，

##### print 只允许输出一个字符串，返回值为1

##### echo输入速度比print快，echo没有返回值，print有返回值

##### echo 和print是语言结构(language construct)，而并不是真正的函数，因此不能作为表达式的一部分使用 



## 一、echo语句



### 1、输出字符串

字符串里面可以包含html标签

```php
<?php
    echo "<h2>PHP 很有趣!</h2>";
    echo "Hello world!<br>";
    echo "我要学 PHP!<br>";
    echo "这是一个"，"字符串，"，"使用了"，"多个"，"参数。";
?>
```

echo使用 的时候可以加括号，也可以不加括号，

这里面可以输出多个参数，以逗号分隔

### 2、输出变量与其他类型

输出变量和数组值

```php
		<?php
			$txt1="学习 PHP";
			$txt2="RUNOOB.COM";
			$cars=array("Volvo","BMW","Toyota");
			 
			echo $txt1;
			echo "<br>";
			echo "在 $txt2 学习 PHP ";
			echo "<br>";
			echo "我车的品牌是 {$txt1}";
		?>
```

在这个里面

如果只是单纯的引用变量，就直接写$ +变量，

如果是在一个字符串里面写入变量，有两种方法，一种是直接写入进去，不过注意在后面必须有一个空格，第二种是加一个大括号{}，然后将变量写入到里面

## 二、print

### 1、print可以使用括号，也可以不用，和print一样

### 2、print输出字符串和变量的方式和echo相同

