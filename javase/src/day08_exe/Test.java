package day08_exe;

public class Test {

	
	public abstract void m1();
	
	public static void main(String[] args) {
		
//		//父类引用指向子类
//		Father f1 = new Son1();
//		Father f2 = new Son2();
//		
//		//子类引用指向父类
//		Son1 son1 = (Son1) new Father();
//		Son2 son2 = (Son2) new Father();
		
		
		//欺骗JVM
		
//		
//		Son2 sons = (Son2)f1;
//		
//		System.out.println(sons);
		
		
		//父类调用子类的方法
		Father f = new Son1("二狗子");
		f.eat();
		
		
		
		
		
		
		
		
	}

}
