# 数组应用

## 一，选择排序

```java
public static void main(String[] args) {
		
		int k , temp , i , j;
		int[] a = {21,12,32,41,25 , 526 , 65};
		
		for(i = 0;i<a.length-1;i++) {
			
			k = i;
			
			for(j = i;j<a.length-1;j++) {
				if(a[k] >a[j+1] ) {
					k = j+1;
				}
				
			}
			
			//交换
			temp = a[i];
			a[i] = a[k];
			a[k] = temp;
			
		}
```

**增强for循环**

```java
for(int num : a){
    System.out.println(num); // num就代表了a中的每一项
}
```

## 二，冒泡排序

```java
public static void main(String[] args) {
		int[] a = {21,12,32,41,25 , 526 , 65};
		int temp;
		
		for(int i = 0;i<a.length - 1;i++) {
			
			for(int j = 0;j<a.length - 1 - i;j++) {
				
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
		}
		
		for(int num: a) {
			System.out.print(num + " ");
		}
	}
```

## 三，二分法搜索

**二分法查找是建立在已经排序好的数组上的**

```java
public static int binarySearch(int num , int[] arr) {
		//num表示要查找的数字，arr则是查找的数组。
		int begin = 0;
		int end = arr.length - 1;
		int mid;
	
		while(begin <= end) {
			mid = (begin + end ) / 2;
			
			if(arr[mid] == num) {
				return mid;
			}else if(arr[mid] > num) {
				end = mid -1;
			}else {
				begin = mid + 1;
			}
			
		}
		return -1;
		
	}
```

## 四，常用数组方法

**数组的一些方法都封装在Arrays类里面**

```java
//可以查看API文档查看结果
```







