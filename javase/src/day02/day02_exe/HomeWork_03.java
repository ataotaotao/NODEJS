package day02.day02_exe;

public class HomeWork_03 {
	/*
	 * 输入两个小数，存入a,b中，编程实现a与b变量中的值交换，最后输出a与b中的值。
	 * */
	public static void main(String[] args) {
		float a = 2.3f;
		double b = 4.5;
		double c = b;
		b = a;
		a = (float) c;
		System.out.println(a);
		System.out.println(b);
	}
}
