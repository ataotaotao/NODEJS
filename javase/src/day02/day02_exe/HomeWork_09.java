package day02.day02_exe;

public class HomeWork_09 {
	/**
	 * 输入一个整数，代表有n个小时，计算n个小时等于多少天零多少个小时。比如输入：	25，那么输出“1天零1个小时”
	 */
	public static void main(String[] args) {
		int n = 125;
		int d = n / 24;
		n -= d * 24;
		System.out.println(d + "天" + n + "小时");
	}
}
