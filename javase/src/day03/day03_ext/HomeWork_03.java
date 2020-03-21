package day03.day03_ext;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 编写java程序，接受用户输入的1-12之间的数，利用switch语句输出对应月份的天数。

 * */
public class HomeWork_03 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("输入月份数:");
		
		
		int monthNum = in.nextInt();
		//判断月份输入是否正确
		if(monthNum >12 || monthNum <=0) {
			System.out.println("月份输入有误");
		}else if(monthNum == 2) {
			Scanner year = new Scanner(System.in);
			System.out.print("请输入年份:");
			
			int yearNum = year.nextInt();
			
			Calendar date = Calendar.getInstance();
	        int years = Integer.parseInt(String.valueOf(date.get(Calendar.YEAR)));
			if(yearNum > years || yearNum <0) {
				System.out.println("年份输入出错");
			}else {
				if(yearNum %4 ==0 && yearNum %100 != 0 || yearNum % 400 == 0) {
					System.out.println("天数是29天");
				}else {
					System.out.println("天数是28天");
				}
			}
			
			
		}else if(monthNum <8){
			monthNum %= 2;
			switch(monthNum) {
			case 0:
				System.out.println("天数是30天");
				break;
			case 1:
				System.out.println("天数是31天");
				break;
			}
		}else {
			monthNum %= 2;
			switch(monthNum) {
			case 0:
				System.out.println("天数是31天");
				break;
			case 1:
				System.out.println("天数是30天");
				break;
	
			}
		}
		
		
		
		
	}
}
