package day07_homework;

/*
 * 3.研究生类Graduate增加成员direction(研究方向)。添加GraduateShow()方法，用于输出数据成员信息
 * */

public class Graduate extends Student {
	protected String direction;
	
	public Graduate(String name , int age , String degree ,String direction ) {
		super(name , age , degree);
		this.direction = direction;
	}
	
	
	@Override
	public void Show() {
		System.out.println("[我的名字是"+super.name+",我的年龄是"+super.age+",我的学位是"+this.degree+"]");
	}
	
	public void GraduateShow() {
		System.out.println("[我的名字是"+super.name+",我的年龄是"+super.age+",我的学位是"+this.degree+",我的研究方向是"+direction+"]");
	}
}

