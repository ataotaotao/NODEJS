package day05_面向对象1;

public class 封装 {
	private String name;
	private int age;
	private BasicKnow human; // 这个是自定义的属性，是自定义的类
	
	/*
	 * sun公司只给我们提供了一些常用的类，我们可以自定义类
	 * */
	
	
}

/*
	封装
		好处：保护变量/隐私，安全
		
		Man leo= new Man();
		leo.age = 20;
	
		这样很不好，数据可以随便赋值，我们要将数据保护起来。
		
		封装解决了数据的安全性问题，同时便于维护和扩展
		
		
	如何封装：
		1. 隐藏对象的属性和实现细节
			
			将属性私有化 ---> 在属性前面加上private修饰符。
			
		2. 对外提供一个公共的访问方法
		
			public void setAge(int _age){、
				
				//添加条件
			
				//对_age进行判断，如果正常赋值，如果不正常报错。
				age = _age;
			}
			public int getAge(){
				return age;
			}
			
			如果有的属性不想让外部得到，可以设置private，而且不对外设置getter 和setter
			
			具体情况根据实情来分析是否提供get和set
			
			
	如果有属性在类定义的时候没有赋值，但是又没有提供set方法
	通过构造方法解决
	
	
	
	
			
  
  
  
 */
