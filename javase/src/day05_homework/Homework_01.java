package day05_homework;

/*
 * 1、写一个传奇游戏中的猪类，类中有属性：颜色、个头、攻击力、准确度。有一个展示猪信息的方法。
 * 	再写一个测试类，生成一个猪的对象，
	将此猪的颜色值为“白色”，个头为5厘米，攻击力为50点血，准确度为0.8。
	要求输出此猪的信息格式为：一只白色的猪，个头5厘米，攻击为为50点血，准确度为0.8，我好怕怕呀

 * */

public class Homework_01 {
	//猪类
	private String color;
	private String size;
	private int attack;
	private double accurate;
	
	public void showinfo() {
		System.out.println("一只"+color+"的猪，个头为"+size+"，攻击为"+attack+"点血，准确度为"+accurate+"，我好怕怕呀!!");
	}
	
	public Homework_01(String _color , String _size , int _attack , double _accurate) {
		color = _color;
		size = _size;
		attack = _attack;
		accurate = _accurate;
	}
	
	
}
