package day05_homework;

/*
 * 3、使用JAVA定义学生类Student：
   a.要求学生类有姓名、性别、年龄、身高,体重 分数，班级Class等属性
   b.提供：自我介绍显示所有属性的值：我是XX班的一名男同学，今年XX岁，身高：XXX，体重XXX，今年考了XX分。
   c.提供dining() 吃饭 和walk()走路的方法：吃饭：显示  我在吃饭，  然后体重增加1；走路：显示 我在走路，然后体重减少1。
   d. 编写测试类Teststudent进行测试：创建2个Student对象的对象：stu1 与 stu2，
   	分别为两个对象的属性赋值，再分别调用每个对象 自我介绍的方法 显示信息。
	并调用对象的dining(),walk()方法，看看输出是否正确?
 * */
public class Student {
	
	private String name;
	private String sex;
	private int age;
	private double high;
	private double weight;
	private int score;
	
	private String Class;
	
	public void introduction() {
		System.out.println("我是"+Class+"班的一名"+sex+"同学，今年"+age+"岁，身高："+high+"，体重"+weight+"，今年考了"+score+"分。");
	}
	
	public void dining() {
		System.out.println("我在吃饭");
		weight++;
	}
	public void walk() {
		System.out.println("我在走路");
		weight--;
	}
	public Student(String _name , String _sex , int _age , double _high , double _weight , int _score , String _Class) {
		name = _name;
		sex = _sex;
		age = _age;
		high = _high;
		weight = _weight;
		score = _score;
		Class = _Class;
	}

	
	
	
}
