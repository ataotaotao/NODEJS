package day03.day03_ext;

import java.util.Scanner;

/*
 * 输入一个成绩（double），要求输出这个成绩是什么水平
60以下  不及格   60-70 及格   70-90  良好  90以上  优秀
	用switch做
 * */

public class HomeWork_01 {
	
	public static void main(String[] args) {
		
		//用if做
		Scanner in = new Scanner(System.in);
		System.out.println("请输入浮点型分数:");
		int score = in.nextInt();
		/*if(score >100 || score <0) {
			System.out.println("输入有误");
		}else {
			if(score >= 90) {
				System.out.println("优秀");
			}else if(score >= 70) {
				System.out.println("良好");
			}else if(score >= 60) {
				System.out.println("及格");
			}else {
				System.out.println("不及格");
			}
		}*/
		
		//switch
		if(score >100 || score <0) {
			System.out.println("输入有误");
		}else {
			score /= 10;
			switch(score) {
				case 10:
				case 9:
					System.out.println("优秀");
					break;
				case 8:
				case 7:
					System.out.println("良好");
					break;
				case 6:
					System.out.println("及格");
					break;
				default:
					System.out.println("不及格");
					break;
			
				
			}
		}
		
		
	}
	
}







