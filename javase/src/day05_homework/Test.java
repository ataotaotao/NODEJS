package day05_homework;

public class Test {

	public static void main(String[] args) {
		
		ExeObject obj = new ExeObject(new Human());
		System.out.println(obj);
		obj.setAge(25);
		System.out.println(obj.getAge());
		

	}

}
