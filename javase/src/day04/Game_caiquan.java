package day04;

import java.util.Scanner;

/*
 * 	玩家和电脑猜拳，玩家可以选择输入1，2，3 分别代表石头剪刀布
 * 	电脑随机出石头剪刀布，
 * 	规则：
 * 		1局定胜负
 * 		三局两胜
 * 		一直玩
 
 		随机数   (int)(Math.random()*3+1)
 * */

public class Game_caiquan {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		choose();
		
	}
	public static void choose() {
		
		System.out.println("欢迎来到猜拳游戏，请选择模式：");
		System.out.println("1:一局定胜负; 2:三局两胜; 3:一直玩; 4:退出");
		
		int num = in.nextInt();
		
		//判断是何种模式
		if(num >0 && num <4) {
			play(num);
		}else if(num ==4) {
			System.out.println("退出");
		}else {
			System.out.println("您输入的数字不正确，请重新输入:");
			choose();
		}
	}
		
	public static void play(int n) {
		// 判断是哪种模式
		if(n ==1){
			System.out.println("进入的是一局定胜负模式!!!");
			System.out.println("请输入你的猜拳");
			//此时是一局定胜负
			int num = single();
			if(num ==0){
				System.out.println("玩家胜利");
			}else if(num == 1) {
				System.out.println("平局");
			}else if(num == 2){
				System.out.println("电脑获胜");
			}else {
				System.out.println("输入错误,重新开始");
				choose();
			}
		}else if(n == 2) {
			//三局俩胜制
			System.out.println("进入的是三局两胜模式!!!");
			
			int win = 0; //胜利的次数
			int lose = 0;// 输了的次数
			boolean onoff = true; //用于判断是否执行结果语句
			int num = 0 ; //用于接受返回的结果
			for(int i=0;i<3;i++) {
				System.out.println("请输入你的猜拳");
				num = single();
				if(num ==3) {
					onoff = false;
					System.out.println("输入错误,重新开始");
					choose();
					break;
				}else {
					if(num == 0) {
						win ++;
						System.out.println("玩家胜利");
					}else if(num ==2) {
						lose ++;
						System.out.println("电脑获胜");
					}else if(num ==1){
						System.out.println("平局");
					}
				}
			}
			if(onoff == true) {
				if(win > lose ) {
					System.out.println("玩家赢了,玩家赢了"+win+"次，电脑赢了"+lose+"次");
				}else if(win <lose) {
					System.out.println("真遗憾，下次努力,玩家赢了"+win+"次，电脑赢了"+lose+"次");
				}else {
					System.out.println("最终结果是平局");
				}
			}
			
		}else if(n == 3) {
			System.out.println("进入的是一直玩模式!!!");
			System.out.println("请输入你的猜拳");
			//此时是一局定胜负
			int num = single();	
			if(num ==0){
				System.out.println("玩家胜利");
			}else if(num == 1) {
				System.out.println("平局");
			}else {
				System.out.println("电脑获胜");
			}
			System.out.println("现在你有两个选择，1：继续；2：退出");
			int nums = in.nextInt();
			if(nums ==1) {
				choose();
			}else {
				System.out.println("退出");
			}
		}
		
	}
	
	// 一次猜拳得到的结果是赢了还是输了，返回一个数字。
	public static int single() {
		//一次猜拳
		int choose = in.nextInt();
		int computer = (int)(Math.random()*3+1);
		if(choose > 3 || choose < 0) {
			//玩家输入错误
			return 3;
		}
		if(choose ==1 && computer ==2 || choose ==2 && computer == 3 || choose ==3 && computer == 1){
			//表示玩家赢了
			return 0;
		}else if(choose == computer){
			//平局
			return 1;
		}else{
			//电脑赢了
			return 2;
		}
	}
}






