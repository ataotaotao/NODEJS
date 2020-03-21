package day07_homework;

public class GetSquare {
	
	private final static double PI = 3.14;
	private double r;
	
	private final double Square() {
		return PI * r * r;
	}
	
	public GetSquare(double r) {
		this.r = r;
	}
	
	
	
	public static void main(String[] args) {
		GetSquare circle = new GetSquare(2);
		
		double squa = circle.Square();
		System.out.println(squa);

	}

}
