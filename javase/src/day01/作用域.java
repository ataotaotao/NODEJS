package day01;

public class 作用域 {
	
	
	public static void main(String [] args) {
		
		
		
		//案例1：注意 for循环 作用域问题
		//第一种情况可以输出
		int i;
		for(i = 0; i<10; i++) {
			System.out.println(i);
		}
		System.out.println(i);
		//第二种情况只能输出for循环里面的j，外卖呢的无法输出，因为作用域问题
		for(int j = 0 ; j < 10 ; j ++) {
			//这个j只在for循环有效。
			System.out.println(j);
		}
		//System.out.println(j); //error
	}
}

/*
 * 作用域
 * 1. 出了大括号就不认识了 
 * 2. 当有两个同名变量时，就近原则
 * 		类体中不可以写执行语句，可以写声明语句。
 * 
 * 变量的最后一个知识点：变量的分类
 * 
 * 	变量可以根据出现的位置不同分为两种
 * 		全局变量/成员变量：	出现在类体中，方法体之外
 * 		局部变量：			在方法体中出现的变量，也包括形参。
 * 		
 * 
 * 
 * 
 * 
 * */
