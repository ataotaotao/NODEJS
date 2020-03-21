package day07_exe;

public class Father {
	final static String sex = "女";
	String name;
	int age;
	
	public void names() {
		final int A = 20;
		System.out.println("我的名字是"+this.name);
	}
	
	public String toString() {
		return "我的名字是"+this.name+",我的年龄是"+age;
	}
	
	public Father() {
		
	}
	
	public Father(String name , int age) {
		this.name = name;
		this.age = age;
	}
}	
