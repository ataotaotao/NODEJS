package day02.day02_exe;
/*
 * 
5.定义四个变量，a='A';b='B',c='C',d='D';现在编程实现a与d变量中的
值交换，b与c中的值交换。最后输出a.b.c.d中的值。
 * */
public class HomeWork_05 {
	
	public static void main(String[] args) {
		char a = 'A';
		char b = 'B';
		char c = 'C';
		char d = 'D';
		
		// a 与 b交换
		char e = a;
		a = b;
		b = e;
		
		//c与d交换
		char f = c;
		c = d;
		d = f;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}
	
	
}
