package day10_异常;

import java.io.FileInputStream;

public class DealException {

	public static void main(String [] args) {
		
		try {
			FileInputStream fis = new FileInputStream("123");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("文件没找到");
		}
		
		
		
		
	}
}

/*
 * 
 	异常的处理
 		抛出  throws
 		捕获	try...catch
 		
 	throws
 		使用throws来处理异常，其实并不是真正的处理异常而是推卸责任。
 		谁调用抛给谁
 		
 		例如m1方法有异常，然后m2调用m1，m1抛出了异常，那么m2报错，
 		m2抛出异常，最后main方法调用m2，也抛出异常，最后虚拟机调用，
 		也抛出错误，最后运行就报错。
 
 		
 		main方法是虚拟机调用的。
 		
 		
 		
 	异常的分类
 		编译时异常 ---> 编译出现的异常 		均继承了Exception
 		运行时异常 ---> 运行出现的异常		继承了RuntimeException
 		
 	书写
 		throws 异常名字  可以直接写继承父类。
 		
 	
 	javac 编译
 	java  运行
  	
  	
  	
  	try catch
  		
  		捕获异常并处理
  		
  		try catch可以有很多的catch
  		判断try里面出现了的异常的种类，如果第一个catch处理不了，
  		就是用第二个catch进行判断。
  		
  		try{
  			//可能出现异常的代码
  		}catch(异常类型 变量){
  			//处理异常的代码
  		}catch( Exception e){
  			
  		}
  		
  		1. catch可以有多个，但是从上到下，catch必须从小类型异常到大类型异常
  		2. 语句虽然可以有多个catch，但是最多只执行一个catch
  		3. e有一个方法叫做printStackTrace，打印异常信息。
  			这也是一种处理方式，将异常的结果打印出来
  			后面的代码可以执行。JVM并没有退出。
  		
  		
  		
  		
  
 */
