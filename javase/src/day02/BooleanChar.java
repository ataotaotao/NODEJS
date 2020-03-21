package day02;

public class BooleanChar {
	public static void main(String[] args) {
		char c = 48;
		System.out.println(c);
		char d = 'y';
		System.out.println(d);
	}
}




/*
 * 布尔型	在java中有且只有两个值。
 * 	true
 * 	false
 * 
 * 	bool值默认false
 * 
 * 
 * 字符型 	char
 * 	乱码	
 * 	语言是由外国人发明的
 * 		ASCII		针对英文的编码	-> 只有二十六个字母。
 * 		ISO-8859-1	针对西欧的语言	兼容ASCII
 * 		GBK			主要针对中文
 * 		BIG-5		针对繁体字
 * 		Unicode		统一全世界所有的编码
 * 
 * 	在写程序的时候，如果用GBK进行加密， 但是解密用UNICODE，那么就是乱码，所以加密解密都得用同一种编码
 * 	
 * 	char
 * 		占两字节	一个英文占一个字节，一个汉子占两字节。
 * 		char的值就是UNICODE中所含有的值。单个出现
 * 		UNICODE中的值是有顺序的。
 * 		UNICODE就是UTF,他有几种不同的实现形式。
 * 		UNICODE就类似于一张表，每个在里面都占有一个位置。
 * 	如果直接 char c = 48; 则48表示在unicode中的顺序，就表示0
 * 	char的范围是0~65535，所以可以取值的范围是0~65535
 * 	char字符型使用单引号声明。不能使用双引号。
 * 	
 * 	字符型不是字符串。	
 * 	char声明的字符可以是单个的，但是不能是多个的。
 * 	基本常见的单个字符都可以，例如,./\[] 。
 * 	
 * 	
 * 
 * 
 * */



