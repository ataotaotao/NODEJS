package day02;

public class DataTypeTransfer {
	public static void main(String[] args) {
		//将short型的s赋值给int型的i
		short s = 1;
		int i = s;	//这句话表示short转int		JVM
		
		byte b = (byte)s;	//强制类型转化
		
		//第一个声明出现了自动类型转换
		long c = 1;
		long d = 1l;
		
		//练习
		byte e = 1;
		short f = 1;
		char g = 1;
		byte h = (byte) 129;
		System.out.println(h);
	}	
}

/*
 * 数据类型转化
 * 	1. java中除了bool之外，其他基本类型之间可以进行相互转换
 * 		short--->int int ----> short
 * 	2. 转换
 * 		自动类型转换
 * 			小范围转大范围，可行。例如short转int
 * 		强制类型转换
 * 			大范围转小范围	
 * 				int i1 = 5;
 * 			写法：byte b = (byte) i1	写保证书
 * 
 * 深入了解
 * 		第一个声明其实就是将int型转化为long型
 * 		自动类型转化。
 * 		long c = 1;
		long d = 1l;	正常赋值，不存在类型转化。
 * 	
 * 	byte e = 1;
	short f = 1;
	char g = 1;
	
 * 	JVM规定了:
 * 		如果一个整数没有超出byte，short，char的范围，则可以直接将整数赋值给byte，short，char
 * 		JVM已经自动处理了
 * 	强制类型转换可能损失精度，谨慎使用
 * 	几种类型的运算：
 * 		byte，short，char做混合运算时，先各自转换成int，然后再运算，因此结果为int型。
 * 		多种数据类型做混合运算，先转化成容量大的，然后再运算。
 * 		几种类型排序：	升序
 * 			byte
 * 			short/char
 * 			int
 * 			long		long小于float
 * 			float
 * 			double
 * 	为什么long小于float，
 * 		long为整数型，可以表示出来，-2^63~2^63-1
 * 		float的分配方式和整型不同。
 * 		1   	符号
 * 		2-9 	表示底数
 * 		10-32 	表示指数
 * 
 * 
 * 
 * 
 * */
