# 多线程

## 两种方式

**进程**

+ 进程：电脑上独立运行的 一个程序，每一个进程都有独立的代码和数据空间
+ 一个进程至少包含了一条线程

**线程**

+ 同一类线程共享代码和数据空间，每个线程有独立的运行栈和程序计算器（个人管个人的，个人有个人的独立路线）

**CPU** 每一个CPU在同一时间节点只能给一条线程分配资源。时间间隔十分小，那么看起来就是连续的。

单核电脑也可以一边看视频，一边听歌。

```java
//线程的生命周期
创建 ----- 就绪 ----- 运行 ----- 消亡  
若没有分配到资源，还有一个 ---------- 阻塞
```

**想在java中实现多线程，有两种方法**

+ 继承Thread类并重写run方法
+ 实现runnable接口并实现run方法。

```java
//方法一：
class MyThread extends Thread{
    
    //重写run方法
    @Override
    public void run(){
        //想做的事儿
        for(int i = 1;i<=10;i++0){
            System.out.println(i);
        }
    }
}

public static void main(String[] args){
    MyThread mt = new MyThread();
    
    
    //mt.run(); // 不能直接调用run方法
    //而是调用一个新的栈
    mt.run();
    //start方法结束的瞬间，JVM会再分配一个新的栈给mt线程，并且会自动调用run方法
    mt.start();
 	
    
    for(int i = 1;i<=100;i++){
        System.out.println("main第"+i+"次输出");
    }
    
}
```

**一个线程一个栈**

main方法是一个默认的线程，叫做主线程。多线程其实就是几个线程抢资源的过程。当我抢到了资源，我就会输出，当别的线程抢到了资源，那么别的线程就会输出内容

**实现Runnable接口**

```java
class MyThread implements Runnable{
    
    public void run(){ // 做我们应该做的事情
        for(int i = 1;i<=10;i++0){
            System.out.println(i);
        }
    }
}

public static void main(String[] args){
    MyThread mt = new MyThread();
    
    //装饰者模式，将一个thread类传入进去
    Thread t = new Thread(mt);
    
    //dtart方法是Thread类的方法，Runnable接口没有这个方法。
   
    //start方法结束的瞬间，JVM会再分配一个新的栈给mt线程，并且会自动调用run方法
    t.start();
 	
    
    for(int i = 1;i<=100;i++){
        System.out.println("main第"+i+"次输出");
    }
    
}
```

**那种方法更好**

+ 第一种方法是直接继承的，但是JAVA中是单继承，意味着这个类不能再去继承其他类了。
+ 第二种方法留出了一个继承的位置
+ Runnable可以操作同一对象

## 常用方法

```java
public static void main(String[] args){
    
    Thread t1 = new Thread(new MyThread());
    
    //如何获取当前线程对象  静态方法 多注意
	Thread t2 = Thread.currentThread(); //t2保存的是main线程的地址
    Thread t3 = t1.currentThread(); //底层就是Thread.调用。保存的也是main线程。
    
    //给线程起名字
    t2.setName("主线程");
    
    System.out.println(t3.getName()); // t2与t3都是指向的主线程。
    //每个线程都有默认的名字。
    System.out.println(t1.getName())
	
    
    
}

```

**线程优先级并不代表了绝对的优先**

+ 给线程1设置高的优先级，给线程2设置低优先级，优先级是指线程资源的概率的高低。
+ 如果某个线程执行的任务很紧急，这个时候就需要设置优先级
+ 设置方法

```java
t.setPriority(int level); //level表示优先级
t.getPriority(); //查询t的优先级
```

**都有哪些级别**

+ 从1到10，1最低，10最高，如果没有给线程设置优先级，则默认为5，其中最低1，最高，默认5由于用的比较多，所以Thread把他们设为了静态常量。

```java
Thread.MAX_PRIORITY; // 10
Thread.MIN_PRIORITY; // 1
Thread.NORM_PRIORITY;// 5

//设置的优先级超过了10或者小于1，那么就会抛出异常。
```

### 守护线程 `Daemon Thread`

只要JVM中哟一个以上的非守护线程没有结束，守护线程就会工作。

只有当最后一个非守护线程结束时守护线程会随着JVM仪器结束。

守护线程的作用是为其他线程的运行提供便利服务，守护线程最典型的代表是GC（垃圾回收机制）;

守护线程除了JVM内部提供之外，用户编写程序时也可以自己设置

如何设置？

```java
//使用对象设置该对象为守护线程
t1.setDaemon(true);
//这个方法必须在线程跑起来之前设置
t1.start();
```

在守护线程中产生的线程也是守护线程

```java
class Thread01 extends Thread{
    public void run(){
        for(int i = 0;i<10;i++){
           	System.out.println("非守护线程输出"+i);
            try{
			//毫秒数
           	 Thread.sleep(1000); // 需要处理异常,在run方法里面所有的异常只能try/catch，不能抛出去。
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Thread02 extends Thread{
    public void run(){
        for(int i = 0;i<10000000000l;i++){
            System.out.println("守护线程输出"+i);
            
            try{
			//毫秒数
           	 Thread.sleep(10); // 需要处理异常,在run方法里面所有的异常只能try/catch，不能抛出去。
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }
    }
}

public static void main(String[] args){
    Thread01 t1 = new Thread01();
    
    Thread02 t2 = new Thread02();
    t1.start();
    
    //使用对象设置该对象为守护线程
	t2.setDaemon(true);
	//这个方法必须在线程跑起来之前设置
	t2.start();
    
    
    //守护线程设置的量十分大，但是在非守护线程结束之后，守护线程就结束了，因此守护线程在非守护线程执行结束之后就结束了。
    
    //t1.start()调用之后就重新开始了一个方法栈，和main方法的栈是两个，因此t1和main线程是分开执行的，早晚不可预测，但是t1是有sleep的，因此main应该是先执行完成了，而t1是后执行完成。之后，守护线程t2结束。
    
}
```

```java
//线程的五个流程

new MyThread(); // 创建阶段
Mt.start(); // 就绪阶段
//抢到之后就进入了运行状态。
//如果没有抢到资源，那么就是阻塞状态
//如果抢到资源，并运行完成之后，就到了销毁状态。
```

main函数是程序的入口，在执行的时候，已经开始了，由于在执行的时候不能设置守护，因此main线程不能设置为守护线程。

## 另一些常见方法

```java
//sleep 方法，是Thread类的一个方法，目的是让线程进入休眠
//睡觉是阻塞的一种，没有抢到资源就是阻塞。
//让线程先睡一下，
//自然阻塞是线程没有抢到资源，sleep是线程休眠了，压根没有去抢。
Thread t = Thread.currentThread();
try{
    t.sleep(10000);
}catch(Exception e){
    e.printStackTrace();
}
System.out.println("哎呦妈呀");


//interrupt方法， 可以打断sleep，


//wait 方法，等待也是让线程进入阻塞。
t.wait(1000);

//sleep wait
//共同点：它们都是在多线程的环境下都可以在括号中指定时间(毫秒数)
//他们都可以通过interrupt方法打断线程的暂停。会抛出异常。
//不同点：sleep方法是Thread类的方法，是线程用来控制自身流程的。
//wait方法不是Thread类的方法，是Object类的方法。主要用于不同线程之间的调度。

//notify方法：用来唤醒等待的线程。
//自动醒过来的一般用sleep，因为使用wait方法会产生异常。
//wait，notify一般用于多个线程之间的调度，通过另一个类的notify方法可以唤醒这个类的wait方法。比如，一个线程速度比较快，当这个线程到达一个数量界限的时候，另一个速度很慢，效率不高，那么，这个线程可以调用wait方法等待一下，等到另一个线程的数量提升上来之后，另一个线程调用notify方法将这个线程唤醒，两个线程再一起工作。
```

## 线程安全和线程不安全。

```java
//关键字：synchronized
```

**异步编程模型**

+ t1和t2两个线程，t1执行t1的，t2执行t2的，谁也不干扰谁，这就是异步

**同步编程模型**

+ t1和t2执行，t1线程必须等着t2线程执行结束之后才能执行，这就是同步。

同步机制使程序变成单线程

为什么要有同步？

+ 为了数据的安全暂时不考虑效率，比如存钱取钱。

什么时候用同步？

+ 多线程环境
+ 数据共享（几条线程共享一条数据，比如取钱，存钱）
+ 数据涉及到修改操作时。

```java
public class Account{
    
    private int No;  //账号
    private double balance; // 余额
    
    public Account(){}
    
    public Account(String No , double balance){
        this.No = No;
        this.balance = balance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    
    //对外提供取款操作
    public void getMoney(double money){
        
        //更新
        double rest = balance - money;
        
        setBalance(rest);
    }
    
    
}


//写两个线程对账户进行操作
public class Draw implements Runnable{
    
    //关联账户
    Account acc;
    
    public Draw(Account acc){}
    
    public Draw(Account acc){
        this.acc = acc;
    }
    
    public void run(){
        acc.getMoney(1000);
        System.out.println("取款成功，还剩"+acc.getBalance());
    }
    
}




public static void main(String[] args){
    
    //创建账户
    Account acc = new Account(123456789,10000);
    
    //创建取款线程
    Draw draw = new Draw(acc);
    
    //两个方式绑定同一个账户
    Thread t1 = new Thread(draw);
    Thread t2 = new Thread(draw);
    
    //这种情况下不是同一个线程，但是是同一个账户。两种写法没有问题。
    Thread t1 = new Thread(new Draw(acc));
    Thread t2 = new Thread(new Draw(acc));
    
    
    t1.start();
    t2.start(); // 有可能不出错，有可能出错。
}
//取款成功，还剩8000.00
//取款成功，还剩9000.00

//过程：线程1先抢到资源，然后执行代码，先取了1000，然后重新设置余额，为9000.但是在此时，线程2抢到了资源，此时的余额已经是9000，再执行getMoney方法，之后执行setBalance，打印：取款成功，还剩8000.00，之后线程1才抢到资源，输出：取款成功，还剩9000.00

```

```java
//第一种：为了使这种情况不发生，那么可以将取款方法设置为同步方法
public synchronized void getMoney(double money){
        
    //更新
    double rest = balance - money;

    setBalance(rest);
}
//谁抢到了，另外一个必须等待，就是同步。

//第二种，将代码提出来，写一个synchronized代码块
public void getMoney(double money){
    synchronized{
        //更新
        double rest = balance - money;

        setBalance(rest);
        
    }    
    
}
```

**实现同步的两种方法：**

+ 在方法前面加上synchronized
+ 将要同步的代码放在synchronized代码块中  --------> 精准定位
+ 推荐第二中代码块

## 死锁

**死锁是我们在编写程序时应该避免的。**

**死锁是死循环？**

+ 死循环会停下来
+ 死锁会一直卡住

```java
class Huan implements Runnable{
    
    Object o1;
    Object o2;
    public Huan(Object o1 , Object o2){
        this.o1 = o1;
        this.o2 = o2;
        
    }
    
    public void run(){
        //只有jo拿着o1，让线程休眠一会儿，之后huan才能打开o2
        synchronized(o1){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                
            }
            
            //打开代码。且是同步的。
            synchronized(o2){
                System.out.println("门开了");
            }
        }
    }
    
    
    
}

class Jo implements Runnable{
    
    Object o1;
    Object o2;
    public Huan(Object o1 , Object o2){
        this.o1 = o1;
        this.o2 = o2;
        
    }
    
    public void run(){
        //只有huan拿着o2，让线程休眠一会儿，之后huan才能打开o1
        synchronized(o2){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                
            }
            synchronized(o1){
                System.out.println("门开了");
            }
        }
    }
    
}


public static void main(String[] args){
    Object o1 = new Object();
    Object o2 = new Object();
    
    Thread huan = new Thread(new Huan(o1,o2));
    Thread jo = new Thread(new Jo(o1,o2))
        
        
    huan.start();
    jo.start();
}
```

















