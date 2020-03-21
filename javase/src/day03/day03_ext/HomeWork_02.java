package day03.day03_ext;
/*
 * 用while循环打印九九乘法表
 * */
public class HomeWork_02 {
	
	public static void main(String[] args) {
		
		int i = 1;
		
		while(i<10) {
//			System.out.println(i+"i");
			
			//每次执行到这儿的时候，j的值都必须是1，所以要写到里面，不能写外面。
			int j = 1;
			while(j<=i) {
//				System.out.println(j);
				System.out.print(i+"*"+j+"="+i*j+"\t");
				
				j++;
				
			}
			System.out.println();
			
			i++;
			
		}
		
	}
	
}
