package day06_面向对象2;

public class Single {
	
	static Single sing = null;
	
	//防止外部通过new创建。
	private Single() {}
	
	public static Single getSing() {
		if(sing == null) {
			sing = new Single();
		}
		
		return sing;
	}
	
}

/*
 * 
 *
 	单利模式
 		1. 一个类可以拥有无数对象
 		2. 能不能保证某一个类只拥有唯一的一个对象。
 	如何实现单利
 		一个类可以产生多个对象因为构造函数可以多次调用。
 		
 		1. 使用private修饰构造函数。
 		2. 对外提供一个让别人获得对象的公开方法。
 		3. 方法必须是静态的。
 				可以通过类名调用这个方法。
 		4. 将这个对象做成一个静态属性。
 		
 		
 		//这个类返回的是这个类，所以返回值类型是类名
 	缺点：
 		这个只能针对单线程，如果多个人同时调用，可能会创造出多例
 	
 	上面这种是称作懒汉式
 	
 	下面还有一个饿汉式
 	
 		二话不说先new对象
 		优点：简单
 		缺点：太占空间。
 	
 		
 
 */

class Person{
	static Person p = new Person();
	
	private Person() {}
	
	public static Person get() {
		return p;
	}
	
	
}


