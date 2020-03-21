 # 数据类型

## 一、字符串

#### 字符串可以放在单引号和双引号里面

例如：

```php
<?php 
    $x = "Hello world!";
    echo $x;
    echo "<br>"; 
    $x = 'Hello world!';
    echo $x;
?>
```

## 二、整型

### 1、整数规则

 + 整数必须至少有一个数字  
 + 整数不能包含逗号或空格
 + 整数可以使整数或负数
 + 整型有三种模式：十进制，十六进制（前缀为`0x`），八进制（前缀为0）

案例：

``` php
<?php 
    $x = 5985;
    var_dump($x);
    echo "<br>"; 
    $x = -345; // 负数
    var_dump($x);
    echo "<br>"; 
    $x = 0x8C; // 十六进制数
    var_dump($x);
    echo "<br>";
    $x = 047; // 八进制数
    var_dump($x);
?>
    //输出结果
    int(5985) 
    int(-345) 
    int(140) 
    int(39) 
```



var_dump 函数：输出传入数据的变量类型和值

## 三、浮点数

```php
<?php 
    $x = 10.365;
    var_dump($x);
    echo "<br>"; 
    $x = 2.4e3;
    var_dump($x);
    echo "<br>"; 
    $x = 8E-5;
    var_dump($x);
?>
    //结果
    float(10.365)
    loat(2400)
    float(8.0e-5) // 0.00008
```

## 四、boolean值

两个值：true，false

##### 一般用于条件判断



## 五、数组

数组可以在一个变量中存储多个值

数组声明方法：

```php
<?php
    $cars = array("hello","world","better");
	var_dump($cars);
?>
    //结果
    array(3) { 
    	 [0]=> string(5) "Volvo" 
         [1]=> string(3) "BMW" 
         [2]=> string(6) "Toyota" 
	}
```



## 六、null值

null值表示变量没有值，null数据类型为null，null值致命一个变量是否为空值，同样可用于数据空值和null值的区别

可以通过设置变量值为null来清空变量数据

```php
<?
    $x = "hello world";
	echo $x;
	$x = null;
	echo $x;
?>
    //输出结果
    "hello world"
    null
```

