package day06_面向对象2;

public class This {
	private String name;
	
	public void setName(String name) {
		this.name = name;
		this.m();
	}
	public void m() {
		System.out.println("我是m方法,私有属性name的值为"+this.name);
	}
	
	public void strings() {
		System.out.println("调用了成员方法");
	}
	
	public This() {
		this.strings();
		System.out.println("调用了无参的构造方法");
	}
	public This(String name) {
		this();
		this.name = name;
		System.out.println("调用了有参的构造方法，参数是"+this.name);
	}
	public This(String name , int age) {
		this();
		
	}
}

/**
 * 
 * 
 * 
 
 this关键字
  	this代表了当前类的对象。
 		当使用this的时候，对象还没有产生，
 this的作用：
 	访问对象的成员，也就是属性和方法，
 	并且在不产生歧义的情况下，可以省略this
	
	调用类的构造方法
		this();
		只有构造方法才能调用构造方法。 无参可以调用有参
		构造方法可以调用成员方法。
		两个构造方法不可以同时相互调用。
		调用构造方法的this只能写在第一行。
		构造方法中不能同时调用两个参数不同的构造方法。
		
 
 
 * 
 */
