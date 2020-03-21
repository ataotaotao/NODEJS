package day03.day03_ext;

import java.util.Scanner;

/*
 * 
 * 作业：输入a行   *
 * */
public class HomeWork_04 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("请输入行数：");
		
		int num = in.nextInt();
		//for循环
		for(int i = 0;i<num;i++) {
			
			for(int j =0 ; j<=i;j++) {
				
				System.out.print("*");
				
			}
			
			System.out.println();
		}
		
	}
	
}
