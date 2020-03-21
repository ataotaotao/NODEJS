package day07_homework;

/*
 * 1.设计一个学生类Student，其数据成员有name(姓名)、age(年龄)和degree(学位)。Show方法显示信息。 
 * 	构造函数由Student类派生出本科类与研究生
 * */
public class Student {
	protected String name;
	protected int age;
	protected String degree;
	
	public void Show() {
		System.out.println("我是"+this.name+",我的年龄是"+age+",我的学位是"+degree);
	}
	
	public Student(String name , int age , String degree) {
		this.name = name;
		this.age = age;
		this.degree = degree;
	}
	
}
