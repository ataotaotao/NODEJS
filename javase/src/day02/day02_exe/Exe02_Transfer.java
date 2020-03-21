package day02.day02_exe;

public class Exe02_Transfer {
	public static void main(String[] args) {
		short a = 1;
		int b = a;
		float c = 1.2f;
		double d = c;
//		System.out.println(d);
		
		int e = 23;
		short f = (short) (e + 5);
		long g = 34; // 自动类型转化
		long h = 34l;
		
		byte i = 2;
		short j = 3;
		char k = 34;
		
		int l = 1345;
		byte m  = (byte) l;
//		System.out.println(m);
		
//		System.out.println(a + b + c + i + g);
		
		//算数运算符
//		System.out.println(e+g);
//		System.out.println(e-g);
//		System.out.println(e*g);
//		System.out.println(e/g);	
//		System.out.println(e%g);
		
		//自增自减
//		System.out.println(a++);
//		System.out.println(a);
		
		//逻辑运算符
		int n = 5;
		int o = 6;
//		System.out.println(n&o);//4
//		System.out.println(n|o);//7
//		System.out.println(~n);//  
//		System.out.println(n^o);// 3
//		System.out.println(n>>2);
		
		
		//&& and ||
		boolean p = false && a >0;
		boolean q = true && b > 0;
		
		
		int r = 34;
		float s = r>25?13:15.2f;
		System.out.println(s);
		
		
		/**
		 *    0000 0101
		 *    0010 1000
		 *    
		 *    
		 * 
		 * */
		
		
		
	}
}
