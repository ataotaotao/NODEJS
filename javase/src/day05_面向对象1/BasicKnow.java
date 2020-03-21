package day05_面向对象1;

public class BasicKnow {
	
	//main方法是程序的入口，也就是程序最开始的地方。
	//main方法是被JVM调用。
	
	//属性
	String name;
	int age;
	char sex; // 也可以用bool表示 只有男女两种
	
	//方法
	public void eat() {
		System.out.println("吃饭");
	}
	public void sleep() {
		System.out.println("睡觉");
	}
	
	public static void main(String[] args) {
		
	}
}
/**
 	面向对象
 		java语言的核心思想
 		
 	面向过程：耦合性太强，但是能够节省很多的资源。
 	
 	面向对象的三特性：
 		继承，封装，多态
 	
 	类与对象
 		类是对具有共性事物的抽象描述
 		对象是类的实例 ， 有一组属性和方法构成。
 	类的声明
 		类的定义格式
 			控制权限修饰符	class 类名{
 				//类体
 				属性 + 方法
 				属性：类所固有的一些特性
 			 	方法：类所拥有的动作和行为
 			}
 	对象的创建格式
 		类名	对象 = new 类名();
 		Human ren = new Human();
 
 
 */