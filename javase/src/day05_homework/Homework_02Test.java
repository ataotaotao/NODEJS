package day05_homework;

public class Homework_02Test {

	public static void main(String[] args) {
		Homework_02 computer = new Homework_02("联想","T400 INTER 双核","中国",7000.00);
		computer.show();
		System.out.println("------------------------------");
		computer.setBrand("DELL");
		computer.setType("inter  i5");
		computer.setMadeIn("美国");
		computer.setPrice(8000.00);
		computer.show();
	}

}
