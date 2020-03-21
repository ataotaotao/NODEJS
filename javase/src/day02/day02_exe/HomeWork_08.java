package day02.day02_exe;

public class HomeWork_08 {
	/**
	 * 输入一个四位数的整数，要求编程将这个四位数中的个位，十位，百位，千位分别输出。
	 * 
	 */
	public static void main(String[] args) {
		int a = 1234;
		int thousand = a / 1000;
		a -= thousand * 1000;
		int hundrand = a / 100;
		a -= hundrand * 100;
		int ten = a / 10;
		a -= ten * 10;
		int sirgle = a;
		System.out.println(thousand);
		System.out.println(hundrand);
		System.out.println(ten);
		System.out.println(sirgle);
	}
}
