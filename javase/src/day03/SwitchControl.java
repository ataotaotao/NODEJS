package day03;

import java.util.Scanner;

public class SwitchControl {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		switch(num) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("工作日");
				break;
			case 6:
			case 7:
				System.out.println("周末");
				break;
			default:
				System.out.println("输入出错");
				break;
		}

	}

}

/**
 * switch语句
 * 	多种选择
 * 	jdk1.5之前，支持char byte short
 * 	jdk1.5之后，支持枚举
 *  jdk1.7的新特性：支持String
 * 	语法:	
 * switch(条件){
 * 		//值用于和条件匹配
 * 		case 值1:
 * 			break;
 * 		...
 * 		default:
 * 			break;
 * 
 * }
 * 条件和值符合，就执行下面的代码，可以有很多的情况。
 * 
 * 注意：default和break不是必须的。
 * 	case穿透：如果没有break；所有case里面的语句都会执行。避免这种现象的产生
 * 
 * case合并，其实就是case穿透
 * 		如果有几个case的情况是相同的，那么可以使用几个case一个代码
 * 	case 3:
 *  case 4:
 *  case 5:
 *  	代码；
 * 
 * 
 * 
 * 
 * */
