package day08_面向对象四;

public class DuoTai {
	public static void main(String[] args) {
		
		String a ="42";
		
	}
}

/*
 	多态
 		建立在继承上面的。
 		
 		向上转型
 		父类的引用
 		父类 	引用 = new  子类();
 	多态的一种表现形式：父类的引用指向子类的对象。
 		
 		向下转型
 		如果要用子类的引用指向父类的对象
 		那么需要保证
 		
 		小范围指向大范围需要保证
 		Dog a = (Dog)new Animal();
 		
 		
 		
 		Animal a = new Bird();
 		//此时不报错 ， 欺骗了JVM
 		Dog dog = (Dog)a;
 		
 		//此时会报错。
 		System.out.println(dog);
 		
 		
 		
 	检测对象是否是类的实例
 		animal instanceof Dog
 			检测animal是否是Dog的实例。
 		
 	多态的另一种表现形式：父类的引用调用子类的方法。
 		
 	面向父类编程。
 	
  
 */
