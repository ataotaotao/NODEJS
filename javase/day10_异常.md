# 异常

### 一，异常模拟的是现实生活中的不正常事件

​		

```
	2. java中采用类去模拟异常
	
	3. 类可以创建对象，类表示一类异常，对象就表示这一类异常中的某个具体事件
异常的作用
```


​	
​		
​	
```
	异常处理机制：JAVA为我们提供了一种完善的异常处理机制
	
	如果异常产生了，且没有处理，那么JVM会直接退出. 后面的代码就不会执行。
```


​		
​		
```
	当程序中发生异常后，为我们输出详细信息。
```


​		
```
		我们可以通过这个信息，对程序进行一些处理。使程序更健壮。robust
		
		处理方式：
			可以用简单的if else 方法来进行判断
			
			也可以专门处理异常。
```




## 二，两类方法处理异常



### 1. 异常的分类

```java
1. 编译时异常 ---> 编译出现的异常	均继承了Exception
1. 运行时异常 ---> 运行出现的异常	继承了RuntimeException
```

### 2. 第一类

```java
//声明 抛出   throws	在方法声明的位置上使用throws向上抛出异常。
public  static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("123");
    System.out.println("123");
}

/*
	123并不会输出
		使用throws来处理异常，并不是真正的处理异常，而是推卸责任。
		谁调用抛给谁。
		在FileInputStream的构造方法中，也是抛出了异常的，那么main方法使用到了这个类，那么这个异常就抛给了main,那么在主函数中就会报错。
*/
/*
	例如m1方法有异常，然后m2调用m1，m1抛出了异常，那么m2报错，
 		m2抛出异常，最后main方法调用m2，也抛出异常，最后虚拟机调用，
 		也抛出错误，最后运行就报错。
*/
class A{
	//谁调用抛给谁。
	public void m1() throws FileNotFoundException{
		m2();
		
	}
	
	
	public void m2() throws FileNotFoundException{
		FileInputStream fis = new FileInputStream("123");
	}
	
	
}



```

### 3. 第二类

```java
//  try ... catch 捕获并处理
// 语法

try{
    //可能出现异常的代码
    
}catch(异常类型	变量){
    
    //处理异常的代码
    
}catch(异常类型 变量){
    //处理异常的代码
}......
    
    /*
    	需注意：1.catch语句可以有多个，但是从上到下的catch必须从小类型的异常到大类型的异常。
    		2. try catch虽然可以有多个catch，但是最多只执行一个catch。
    
    */
```

```java
//处理代码
//还是用上面的代码，FileInputStream
try{
    
    FileInputStream fis = new FileImputStream("123");
    
}catch(Exception e){
    system.out.println("文件没找到");
    e.printStackTrace(); 
}



//异常类下的printStackTrace方法实际上是处理了异常的内容的，就是将异常的信息输出。后面能够输出123


System.out.println("123");
```

**throws可以抛出多个异常，异常与异常之间用逗号隔开。**

**当程序抛出多个异常，可以直接throws他们的父类异常就可以了。**



## 三，finally



**1.finally语句块，可以直接和try连用 , try....finally**

**2.用的最多  try...catch  .... finally **

**3.在finally中的语句一定会执行,在finally语句块中的代码一定会执行，除非关闭虚拟机**

**4. 通常在程序中为了保证某些资源一定会释放，所以一般在finally语句块中释放资源。**

**5. finally可有可无，但是try...catch必须成对出现。**

```java
/*
	try里面的语句有时候并没有错，那么catch里面的语句并不会执行。
	那么我想有一段代码在try catch中，且一定要执行，又不能放在外面，因此引入finally。
*/

try {
    
    //int a = 0; // 输出我执行了两次。
    FileInputStream fis = new FileInputStream("123");
    // 输出了a不能为0，还输出了我执行了finally 
    //在finally语句块中的代码一定会执行，除非关闭虚拟机()
}catch(Exception e){
    
    System.out.println("a不能为0");
    //return;
    System.exit(0);
    
}finally{
    
    System.out.println("我执行了finally");
    
}

System.out.println("我执行了.")


```

## 四，finally，final，finalize的区别



```java
/*
	finally通常出现在try语句中，finally语句块中的代码一定会执行。
*/

/*
	final是一个修饰符，
		修饰的类不可被继承
		修饰的方法不可被重写
		修饰的成员变量，加上static是常量，赋初值
		修饰的局部变量，不可被修改
*/

/*
	finalize(); 方法名，Object类的一个方法。
		垃圾回收机制中，当一个对象没有引用指向时，就调用finalize方法回收内存。
	
*/
```

## 六，如何自定义异常



很多的不正常事件都是我们自己定义的

```java
/*
	自定义一个非法名字异常
	1.继承异常
		编译时异常	Exception
		运行时异常	RuntimeException
		
	2.提供两个构造方法
		一个无参构造
		一个有参构造，然后调用父类的构造方法。
*/
//1.继承
public class IllegalException extends Exception {
	
	//2.无参构造，最好加上
	public IllegalException() {}
	
	public IllegalException(String msg) {
		super(msg);
	}
	
} 


/*
	throws一般是处理异常，
	throw出现在定义异常里面
	
	throws将类异常抛给调用它的人
	throw抛的是对象。
*/

//具体实现
public class DefineException {

	
	public void register(String name) throws IllegalException {
		
		if(name.length() < 6) {
			
			
			IllegalException e = new IllegalException();
			
			System.out.println("名字长度不能少于6位");
			throw e;
			
		}
		
		System.out.print("注册成功");
		
	}
	
	
	

	public static void main(String[] args) throws IllegalException {
		
		DefineException df = new DefineException();
		
		df.register("1234567");
		

	}

}
```











