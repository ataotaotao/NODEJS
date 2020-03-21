package day06_面向对象2;

public class Static {
	
	public static String sex = "女";
	private int age;
	
	{
		System.out.println("输出构造代码块");
		System.out.println(this.sex);
	}
	static {
		System.out.println("静态代码块");
	}
	
	public void setSex(String _sex) {
		sex = _sex;
	}
}

/**
 * 
 	static
 		静态的。
 	属性的具体指必须具体到对象的时候才能够知道。
 	
 	但是有的类当声明的时候就知道某些属性的值。
 	
 	通过类决定的属性值可以使用static修饰
 	
 	static
 		一个修饰符，用来修饰类的成员，属性和方法
 		在类加载时，就加载。
 		
 		只有所有的对象的该属性是同一个值得时候才建议使用。
 		
 		静态方法里面无法调用非静态的成员。
 		在非static的方法中，可以使用static的成员。
 		
 		类加载的时候成员们还没有产生。
 		
 		static的方法或者语句块中不能使用this，super等关键字
 		
 	
 	类体中不能写执行语句。
 		但是想在类体中写执行语句，又不报错
 		可以使用{}包含起来。
 		这个称之为语句块。
 		
 	构造代码块
 		在类体中的代码块。
 		在对象产生的时候调用。
 		
 		实例化多少对象，调用多少次构造代码块
 	
 	静态代码块
 		static{
 			
 		}
 		
 		静态代码块在类加载的时候加载。
 		
 		无论实例化多少对象，只调用一次静态代码块
 
 	静态属性的引用. 属性        其实底层用的是类名. 属性
 	
 	g.sex = "男";
 	
 	Girl.sex ===> "男"
 	
 	可以通过类.属性或者对象.属性。
 	
 	
 	
 
 * 
 * 
 */
