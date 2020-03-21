package day05_面向对象1;

public class ProcessStoreInJava {
	
	public static void main(String[] args) {
		BasicKnow human = new BasicKnow();
		System.out.println(human.name);
	}
}	

/*
 	程序在内存中的存储
 		非常重要
 		
 		java代码存在内存中的
 		
 		BasicKnow human = new BasicKnow();
 		
 		new BasicKnow()才是 对象。
 		human其实是对象的引用
 		引用存放的就是对象在堆里面的地址
 		对象的引用存放在栈中的。
 		
 		new在这里是开辟的意思，开辟一个新空间
 		用于存放对象
 		
 		每new一次，都意味着开辟了一个新空间
 		
 		new出来的对象存放在堆里面。
 		
 		堆
 			new BasicKnow();
 		栈
 			BasicKnow human 指向上面创建的对象。
 		两个空间存储的东西不同
 		
 		输出human会得到一个十六进制的地址.
 		
 		对象的引用可以通过name来调用属性
 			human.name 就会得到name
 		
 		对象的属性如果没有赋值直接调用，就会使用默认值，
 		例如age属性，没有赋值，但是要用，结果就是0
 		
 		可以通过对象.属性赋值，来改变对象的属性值。
 		在对象被创建出来的时候，因为没有值，就会默认去给默认值，
 		string赋值为null，int赋值为0
 		
 		当去访问的时候，因为在堆内存中的结果是默认值，那就输出默认值
 		当赋值之后，堆内存中的属性值改变了，访问得到的结果就是赋值的结果。
 		
 		垃圾回收机制
 			当java中的对象没有任何一个引用时，垃圾回收机制就会收回这个对象
 			
 	
 */
