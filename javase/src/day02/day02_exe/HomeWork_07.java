package day02.day02_exe;
/**
 * 7.小明买了一双鞋，价值58元，买了3件衣服，每件30元，买了5个包，
 * 	每个包55.8元。小明共交了500元，问还要找回多少元。用程序表达
 * 
 */
public class HomeWork_07 {
	public static void main(String[] args) {
		int shoes = 58;
		int clothes = 30 * 3;
		double bags = 55.8 * 5;
		double sum = shoes + clothes + bags;
		double lasted = 500 - sum;
		System.out.println(lasted);
	}
}
