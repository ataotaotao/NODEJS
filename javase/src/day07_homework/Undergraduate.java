package day07_homework;

/*
 * 2.本科生类Undergraduate和研究生类Graduate，本科生类Undergraduate增加成员
 * 		specialty(专业)，添加方法UndergraduateShow()显示信息，
 * */

public class Undergraduate extends Student{
	
	protected String specialty;
	
	public Undergraduate(String name , int age , String degree , String specialty) {
		super(name , age , degree);
		this.specialty = specialty;
	}
	
	@Override
	public void Show() {
		System.out.println("[我的名字是"+super.name+",我的年龄是"+super.age+",我的学位是"+this.degree+"]");
	}
	
	public void UndergraduateShow() {
		System.out.println("我叫"+this.name+", 我的年龄为"+super.age+",我的学位是"+degree+"，我的专业是"+specialty);
		
	}
	
}
