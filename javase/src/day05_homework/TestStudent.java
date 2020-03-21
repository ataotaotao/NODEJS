package day05_homework;

public class TestStudent {

	public static void main(String[] args) {
		Student stu1 = new Student("小王","男",18,1.56,58.7,96 , "6年级2班");
		Student stu2 = new Student("小张","女",18,1.56,68.9,25 , "5年级3班");
		stu1.introduction();
		stu2.introduction();
		stu1.walk();
		stu2.walk();
		stu1.introduction();
		stu2.introduction();
		
		

	}

}
