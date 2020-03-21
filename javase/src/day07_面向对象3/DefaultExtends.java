package day07_面向对象3;

public class DefaultExtends {
	String name;
	
	//重写equals
	public boolean equals( Object o ) {
		
		if(this == o) {
			return true;
		}else {
			//需要将Object强行转为当前类型
			if(o instanceof DefaultExtends) {
				DefaultExtends p = (DefaultExtends) o;
				//这里可以继续加类型，直到满足条件为止。自己定义哪些需要的。
				if(p.name == this.name) {
					return true;
				}
			}
			return false;
			
			
			
		}
		
	}
}

/*
 	Object
 		在java中被定义为一个顶级父类
 		
 		它是任何类的父类。
 	Object类的两个最常用方法
 		toString()
 		equals()
 		
 	所有的类都有这两个方法。
 	
 		toString会返回一个以文本方式表示的此对象
 			默认将该对象在堆中的地址。将其变成字符串返回回来
 		
 		输出一个对象，就是默认调用了toString方法。
 		
 		我们需要的结果是一个简单易懂的信息表达式，
 			所以建议所有子类都重写此方法。
 		
  	equals
  		
  		1. 是一个比较方法，默认比较的是对象的地址。 与 == 相同
  		2. 一般来说我们用equals方法类比较对象的内容
  		3. 所以我们需要重写
  		4. 比较的值如果相同返回true，否则返回false
  		
  	需要重写equals方法
  
  
 */
