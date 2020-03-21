package day09_exe;

public class PartInnerClass {
	
	
	int a;
	public static String b;
	public String test() {
		return "二狗子";
		
	}
	
	//可以看作是成员变量
	private class InnerClass{
		int a;
		protected String b;
		public int c;
		public void show() {
			System.out.println(test());
			System.out.println(a);
			System.out.println(b);
		}
	}
	
	
	public static void main(String[] args) {
		PartInnerClass p = new PartInnerClass();
		InnerClass in = p.new InnerClass();
	}
	
	
}
