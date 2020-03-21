package day08_面向对象四;

public class Interface {

}


interface in{
	//接口
	void m1();
	void m2();
}


/*
 * 
 * 
	接口
		如果一个类的所有方法都是抽象的，可以定义为接口
		
		1.接口同样不能实例化。
			接口中不能有构造方法
		2. 接口用 interface定义
			
		3. 接口中定义的方法不能有方法体，默认public abstract;
		
		4. 接口的控制访问修饰符只能是public和默认(不写);
		
		5. 接口中可以有变量，但是默认由public static final
				----> 常量
		
		6. 类实现接口，而不是继承 使用关键字implements。
				
				
	一个类如何实现接口
		implements
		
		class A implements In{}
		
		
	继承是单继承， 但是接口可以多实现
		
		implements In,In2,In3 .... 
		
	实现的同时，还可以继承
		
		extends Animal implements In,In2,In3 .... 
		
		
	接口与接口之间叫做继承
		
		In1 extends In2{}
		
		
	抽象类和接口的区别
		
		
	接口的作用:
		1. 使得项目分层， 面向接口开发，提高效率
		2. 项目可以插拔
		
		
	


 */