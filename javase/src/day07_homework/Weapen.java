package day07_homework;


/*
 * 
第二题：
1.创建一个武器类Weapen，具有攻击力Power(public ),速度speed(public )字段，并实现构造方法


4.为Tank类和Bullen类定义构造函数初始化属性（要求使用super调用父类的构造函数）
5.创建一只Tank对象，调用其方法；创建一只Bullen，调用其方法
 * 
 * 
 * */

public class Weapen {
	public double Power;
	public double speed;
	
	
	public Weapen(double Power , double speed) {
		this.Power = Power;
		this.speed = speed;
	}
	public void attack() {
		System.out.println("我的攻击力是"+Power+"点，我的速度是"+speed);
	}
}

/*
 * 2.创建一个Tank类，从Weapen类继承，具有私有的方向字段dir(上下左右),并用属性封装。定义攻击方法TankAttack(),
		打印“我是坦克，向**方向运动,速度***,攻击力***”
 * */

class Tank extends Weapen{
	private String dir;
	public Tank(double Power , double speed , String dir) {
		super(Power , speed);
		this.dir = dir;
	}
	
	@Override
	
	public void attack() {
		System.out.println("我是坦克，向着"+dir+"方向运动，速度"+this.speed+"，攻击力"+super.Power+"点");
	}
	
}

/*
 * 3.创建一个子弹类Bullen，从Weapen类继承，具有私有的type字段(表示子弹类型,如:机枪子弹，步枪子弹)，用属性封装。
		定义攻击方法BullenAttack()，打印”我是子弹***，速度***，攻击力***”
 * 
 * */

class Bullen extends Weapen{
	private String type;
	
	public Bullen(double Power , double speed , String type) {
		super(Power , speed);
		this.type = type;
	}
	
	@Override
	public void attack() {
		System.out.println("我是"+this.type+"子弹，速度"+speed+"，攻击力"+super.Power);
	}
}










