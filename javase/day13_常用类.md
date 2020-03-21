# 常用类

## 一，string类----引用数据类型

```java
String s = "123";
```

#### 名字：`java.lang.String` 字符串类型  每一个字符串都是一个对象。

#### `lang`包是默认包，不用导入包

+ 字符串一旦创建将不可改变
+ 为了提升字符串的访问效率，java在程序中使用“缓存”技术
  + 所有在java中使用`""` 双引号括起来的字符串都会在"字符串常量池"中创建一份，"字符串常量池"存储在方法区中。

#### 内存不仅有堆和栈，而且还有一个方法区，方法区内开辟了一个区域，就是一个字符串常量池。

####　在程序执行过程中，如果程序要用到某个字符串，那么它会首先去字符串常量池中找，如果有，则直接拿来用，如果没有，则在字符串常量池中创建一个再用。

**辨析**

```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
String s4 = new String("hello");

System.out.println(s1.equals(s2));//T

System.out.println(s1==s2);//T
System.out.println(s1==s3);//F
System.out.println(s1==s4);//F
System.out.println(s3==s2);//F

/*
	s2与s2存储在字符串常量池中，因此s2在创建的时候会先检查字符串常量池中是否有hello字符串，此时是有的，因此就会将内容直接拿来使用，故s1与s2地址相同，
	equals方法比较的是值，所以是true，
	下面的new String则是在堆中开辟了一个新空间，不属于字符串常量池中，因此三个都是false
*/

//请问下面三条语句分别创建了几个对象，分别是什么
String s = new String("xiaotui");//2个
String s1 = "xiaotui";//没有
String s2 = new String("xiaotui")//1个
    
    
    分为三个区域，堆，栈，方法区， 第一个先new一个，之后在字符串常量池中再创建一个。
    
    //求结果
String hello = "hello";
String hel = "hel";
String lo = "lo";

System.out.println(hello == "hel" + "lo");//T
System.out.println(hello == hel + "lo");//F 找了中间人 xxxxxx
```

## 二，常用方法

```java
//toString()
//equals() 比较内容是否相同。
String s = "123456789";

/*
	方法1：s.length();长度
	
	方法2：截取当前字符串的一部分
		str = s.substring(2);
		传入一个参数，表示从下标为2的字符开始向后截取到最后
		str = s.substring(2,5);
		传入两个参数，表示从小标为2的自负开始向后截取到第五个。
		取头不取尾
		
	方法3：去空格，不能去中间的空格
		s.trim();
		去掉两边的空格，不能去中间的空格。
		
	方法4：以xx开头，以xx结尾
		s.startsWith(xx);
		返回布尔值。
		s.endsWith(xx);
		
	方法5：获取字符串中的某个字符 变成了char类型
		s.charAt(0); //根据下标获取字符
	
	方法6：大小写转换
		s.toUpperCase();//大写转小写
		s.toLowerCase();//小写转大写
		
	
	方法7：忽略大小写
		s.equalsIgnoreCase(s1); // 忽略大小写的比较
		
	.....还有很多方法，可以查看API
*/
```



## 三，`stringBuffer`

**字符串缓冲区**

**1.工作原理：预先在内存中申请一块空间，用来容纳字符串，默认初始化容量为16**

**2.如果预留的空间不够，则会自动扩容**

**`string`和`StringBuffer`的区别**

+ String一旦创建，将不可改变
+ `StringBuffer`的底层是`char`数组，16个，如果还有多个，那么就有多少就阔多少，它先去检测char数组是否需要扩容。
+ 例如有15个，还要加3个，那么他就会去先新建一个18的数组，之后转移15个，在加入三个。

**`StringBuffer`是可以优化的，最好是在创建`StringBuffer`的时候预测一下字符串数量，指定初始化容量**



## 四，`StringBuffer`的操作

```java
//创建 , 默认初始化容量为16
StringBuffer sb = new StringBuffer();

//优化后的创建,先指定空间有多大。
StringBuffer sb = new StringBuffer(100);
sb = "123";//报错
StringBuffer sn = "123";//报错

//下面的这种方法才可以
sb.append();
//里面可以传入其他类型的数据，会转换成StringBuffer类型的数据
sb.append("123");
sb.append(1);
sb.append(false);   //输出1231false,按顺序输出

//转换成String类型
sb.toString();

//插入方法，插入的位置(下标)和内容
sb.insert(index, "abc");
//插入到下标为index的值的前面。


//删除方法
sb.delete(start,end); //从下标start开始删除，删除到第end个。取头不取尾

```

## 五，`StringBuffer`和`StringBuilder`

#### `StringBuffer`线程安全，`StringBuilder`线程不安全

**三者执行速度比较：**

+ `StringBuilder>StringBuffer>String `















