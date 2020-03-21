package day07_exe;

public class Son extends Father{
	
	public Son(String name , int age) {
//		this.name = name;
//		this.age = age;
		super();
	}
	
	
	
	@Override
	public void names() {
		System.out.println("my name is "+name);
	}
}
