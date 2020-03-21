package day07_homework;

public class Test {

	public static void main(String[] args) {




		Student stu = new Student("tao",18,"本科生");
		stu.Show();
		
		Undergraduate und = new Undergraduate("tao",18,"本科生" , "信息管理与信息系统");
		und.Show();
		und.UndergraduateShow();
		
		Graduate gra = new Graduate("tao",18,"本科生" ,"人工智能");
		gra.Show();
		gra.GraduateShow();
	

	}

}
