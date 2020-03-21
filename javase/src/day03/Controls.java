package day03;

import java.util.Scanner;

public class Controls {

	public static void main(String[] args) {
			
		Scanner in = new Scanner(System.in);
		System.out.println("请输入分数：");
		
		double score = in.nextDouble();
		
		if(score > 100) {
			System.out.println("分数超过100,出错");
		}else {
			if(score >= 90 && score <=100) {
				System.out.println("优秀");
			}else if(score >= 70) {
				System.out.println("良好");
			}else if(score >= 60) {
				System.out.print("及格");
			}else {
				System.out.println("不及格");
			}
		}
		
		

	}

}

/**
 * 流程控制
 * 	顺序语句：顺序执行的语句
 * 	条件语句：
 * 		所有程序语言，都是用来模拟生活。
 * 	if语句主要分为4种
 * 		if(条件){} 只管满足条件的情况
 * 		if(条件){}else{}	满不满足条件都进行处理
 * 		if(条件){}else if(){}... else{}	
 *	if else 语句特点：
 *		执行顺序：从上判断到下。
 *		当一条分支语句执行之后，if语句执行完毕，
 *		当if语句执行到下面的时候，说明上面的条件不满足。
 *		每个条件进行判断的时候只给了两种判断方式。
 * 		
 * 		
 * 
 * 
 * 
 * 
 */

