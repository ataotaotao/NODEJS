package day05_homework;
/*
 * 2、定义 computer  计算机类：
	a、包含属性：品牌 brand； 型号 type ;  如 INTER i3  INTER i5  AMD六核。。。；产地 madeIn ；价格 price。
	b、包含方法：public void show(){ }显示所有的属性值。
	c：定义类时就给属性设置初始值：联想、T400 INTER 双核、中国、7000.00元。
	d：在测试类中创建对象 并调用show方法显示信息。
	e：然后修改这个对象每个属性的值：DELL、inter  i5、美国、8000.00元。
	
	f：再次调用show方法显示属性的值。
 * */
public class Homework_02 {
	private String brand;
	private String type;
	private String madeIn;
	private double price;
	
	public void show() {
		System.out.println("brand:"+brand);
		System.out.println("type:"+type);
		System.out.println("madeIn:"+madeIn);
		System.out.println("price:"+price);
	}
	public Homework_02(String _brand , String _type , String _madeIn , double _price) {
		brand = _brand;
		type = _type;
		madeIn = _madeIn;
		price = _price;
	}
	public void setBrand(String _brand) {
		brand = _brand;
	}
	
	public void setType(String _type) {
		type = _type;
	}
	
	public void setMadeIn(String _made) {
		madeIn = _made;
	}
	
	public void setPrice(double string) {
		price = string;
	}
	
	
}
