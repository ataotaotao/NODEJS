package day04;

public class function {
	
	/* 函数练习 */
	public int add(int a , int b) {
		
		return a + b;
	}
	/* 计算1到n的和*/
	public static int sum(int n) {
		if(n ==1) {
			return 1;
		}
		
		return n + sum(n -1);
	}
	
	
	
	public static void main(String [] args) {
		int gg = sum(100);
		System.out.println(gg);
		int n = add(7);
		System.out.println(n);
	}
	
	public static int add(int n){
		if(n==1 || n==2){
			return 1;
		}
		return add(n-1)+add(n-2);
	}
}

/*
 *	java中叫做方法
 *		其他语言有叫做函数
 *		
 *		方法就是解决一类事情的。
 *		方法的语法：
 *			修饰符  返回值类型   方法名(参数列表){ 方法体 }
 *		public static int/void add(int a , int b){
 *			//int a , int b 称为形式参数。
 *		}
 *		加了static之后同一个类的方法中就可以直接调用了。
 *		
 *		调用的时候add(1,2,3,4) 传入的参数就表示实参。
 *
 *	方法的扩展
 *		如果传入的参数不能保证类型，
 		方法的重载
 			就是说一个类中可以创建多个方法，他们具有相同的名字，但是有不同的参数和不同的定义
 			构成方法的重载的条件
 				1. 方法名相同
 				2. 参数列表不同，参数个数，参数顺序不同。
 				3. 返回值类型不同不构成重载
 				4. 参数不同可以构成重载
 				5. 参数列表的类型相同不构成重载
 					例如：double a ， int b
 						double c , int d
 			为什么要有方法重载
 				为了方便快速地使用某一个方法，减少记忆量
 				无论传入什么内容，都可以找到函数进行处理。
 			
 		递归：
 			自己调用自己。
 			public static void add(){
 				add();
 			}
 			
 			方法是在栈中运行的。
 			
 			必须有一个条件适时地结束调用。
 			
 			
 			总结一下：
 				找规律
 				找边界
 			分析 1到n的和
 			
 				1. 写函数
 				2. 找规律
 					sum(n) = n +　sum(n-1)
 				3. 找边界
 					n=1时不满足规律，
 					边界就是1
 			
 		费波拉契数列 1,1,2,3,5,8,13...
 		public static int add(int n){
 			if(n==1 || n==2){
 				return 1;
 			}
 			return add(n-1)+add(n-2);
 		}	
 			
 *		
 *		
 *
 *
 */
