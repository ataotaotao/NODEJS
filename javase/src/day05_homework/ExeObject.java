package day05_homework;

public class ExeObject {
	// 第一步,私有化属性
	private String name;
	
	private int age;
	
	private Human wife;
	
	//第二步，提供访问的权限
	public String getName() {
		return name;
	}
	
	public void setAge(int _age) {
		if(_age <0 || _age >200) {
			System.out.println("我信你个鬼，你个糟老头子坏得很");
		}else {
			age = _age;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public ExeObject() {
		System.out.println("调用了无参的构造函数");
	}
	
	public ExeObject(Human _wife) {
		System.out.println("调用了一个参数的构造函数");
		wife = _wife;
	}
	
	
}
