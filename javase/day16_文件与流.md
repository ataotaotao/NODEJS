#  文件与流，IO流

**1.文件类，流**

```java
//学习16个：很多类似的
FileInputStream
FileOutputStream
FileReader
FileWriter

BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

DataInputStream
DataOutputStream

ObjectInputStream
ObjectOutputStream

//转换流，将字节流转换为字符流。
InputSreamReader
OutputStreamWriter

//标准打印流
PrintWriter
PrintSream
```

##　一，java中的文件类

**1.`java.io.File`**

**2.File类和流无关，不能通过File类完成文件的读和写**

**3.File是文件和目录路径的抽象表示形式，既可以是文件，又可以是目录**

```java
File file = new File("E:\\a.txt");
//注意\，这是转义字符，需要写入\\

//文件是否存在
file.exists(); // 返回一个bool值。

//新建一个文件，先判断，如果存在，就不用再创建，如果存在，那么就创建。
file.createNewFile(); // 需要抛出异常，有可能存在。

//新建目录
file.delete(); // 删除文件
if(!file.exists()){
    file.mkdir(); // 新建目录。
}

//创建多重目录
File file1 = new File("E:/a/b/c/d/e/f/g");

file1.mkdirs();

//获取文件的绝对路径，包含文件名
file.getAbsolutePath();

//获取文件名，不包含路径
file.getName();

//判断这个file是表示文件还是目录
file.isFile();
file.isDirectory();


//如何拿到一个目录下的所有的子文件,获取结果为一个数组。
File[] files = file.listFiles();
```

```java
//打开一个文件夹下的所有子文件
//使用递归,输出文件名
public static void me(File file){ // 找出所有目录及文件
    
    if(file.isFile()){
        System.out.println(file.getAbsolutePath());
        return;
    }
    
    //若判断是目录，那么还需要一个判断
    if(file.isDirectory()){
        System.out.println(file.getAbsolutePath());
    }
    
    File [] files = file.listFiles();
    for(File f: files){
        //只要求输出文件名
            me(f);
    }
}
```

```java
//获取文件的大小
file.length();//获取到的是文件的字节数

//得到文件的最后修改时间
file.lastModified();//从1970-1-1到最后修改的时间
//一般这么修改,可以用时间类的函数来格式化时间。
new Date(file.lastModified());
```

## 二，流

**流，载体，载的是数据，**

**流的分类：**

+ 按照六的输入输出(以内存为参考)方向分：输入流，输出流
+ 根据读取数据的方式分： 字节流(Stream)，字符流(Reader , Writer)。

## 三，`FileInputSream` 文件字节输入流

**能直接对文件进行操作的，只有四个文件流**

```java
//获取一个文件流
File file = new File(文件名);

//需要抛出异常，因为文件可能不存在
FileInputStream fis = new FileInputStream(file);

//读取内容，返回的是内容，之不是返回的是内容的unicode值，而且它是依次往下读，
//这里空格也是内容，如果内容是空格，那么返回32
//如果返回-1，那么表示没有内容了。
int i1 = fis.read();
int i2 = fis.read();
int i3 = fis.read();
int i4 = fis.read();
int i5 = fis.read();

//利用循环
while(true){
    int temp = fis.read();
    if(temp== -1){
        break;
    }
    System.out.println(temp);
}

//升级循环
int temp;
while((temp == fis.read())!= -1){
    System.out.println((char)temp);
}
```

**上面的读取方式为单个读取，有缺点：**

+ 效率低。
+ 频繁访问硬盘会对磁盘产生伤害。

```java
File file = new File(文件名);
FileInputStream fis = new FileInputStream(file);


//准备一个撞下3个字节的盒子，byte数组 , 这里一般写大一点，最好能够以很少的次数同时照顾到系统的性能。
byte [] bytes = new byte[3];

//返回值为每次读取的字节的个数，如果没有读取到，则返回-1
int i1 = fis.read(bytes ，0 ， i1);

//将数组的内容转化为String
new String(bytes);

//每次读取的返回值为要的个数，因此我们没必要去管覆盖，只需要关注读取个数即可。
int temp;
while((temp= fis.read(bytes))!= -1){
    System.out.println(new String(bytes , 0 , temp));
}


fis.close();
```

## 三，文件字节输出流

**将计算机内存中的数据写入硬盘文件**

```java
//简单来个数据
String s = "io流";
//接收者如果不存在，那么会自动创建文件
FileOutputStream fos = new FileOutputStream(文件名);

//可以传入一个字节数组，也可以一个个地传入
byte[] bytes = info.getBytes(); //将String型的信息转化为数组。
fos.write(字节数组(byte数组))；

//写 , 覆盖文件里面的内容
fos.flush();


//不覆盖，加上true，表示追加。
FileOutputStream fos = new FileOutputStream(文件名 , true);


//将bytes的一部分写入,注意，一个单位代表一个字节，汉字是两个字节，需要注意这点。
fos.write(butes,开始位置，结束位置);

//必须关闭
fos.close();
```

```java
/*
	copy paste
	使用文件字节流实现文件的复制粘贴。
*/
File file1 = new File(文件名);
System.out.println(file1.exists()); //true 存在

File file2 = new File("E:/aim.java");

//准备好操作流
FileInputStream fis;
FileOutputStream fos;

//try catch
try{
    fis = new FileInputStream(file1);
    fos = FileOutputStream(file2,true); // 如果加true，那么就是追加，如果不加，那么就是覆盖。
    
    //边读边写更快
    byte[] bytes = new byte[1024];
    int temp = 0;
    while((temp = fis.read(bytes)) != -1){
        //System.out.println(new String(bytes , 0 ,temp));
        //读多少，写多少。
        fos.write(bytes,0,temp);
    }
    fos.flush(); // 只刷新一次。
    
    
}catch(Exception e){
    e.printStackTrace();
}finally{
    
    //两次分开写，因为如果上一个执行不了，下一个就没法执行了。
    try{
        fis.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    try{
        fos.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}



```

## 四，文件字符输入流

```java

File file = new File("文件路径");
FileReader fr = new FileReader(file);

//byte [] bytes = new byte[1024];
//使用字符数组 和字节输入流的差距就在这里
char[] chars = new char[512];

int temp;
while((temp=fr.read(bytes))!=-1){
    system.out.println(new String(bytes,0,temp));
}

fr.close();
```



## 五，文件字符输出流,`FileWriter`

```java
FileWriter fw = new FileWriter("文件名路径");//文件名可以随便写

fw.write("xxxxx");//可以直接操作String，另类的字符数组。

//也可以直接操作char数组
char [] ch = ['我','是','你'];
fw.write(ch);

fw.flush();
fw.close();
```

案例：用文件字符输入流实现复制粘贴。

```java
public static void main(String[] args) throws IOException {
    File file1 = new File("D:\\Desktop\\JavaSE-墨风\\Day22_文件与流（二）\\1.txt");

    File file2 = new File("D:\\Desktop\\JavaSE-墨风\\Day22_文件与流（二）\\2.txt");

    FileReader fr = null; 
    FileWriter fw = null;

    try {
        fr = new FileReader(file1);
        fw = new FileWriter(file2);

        char[] chars = new char[1024];

        int temp;
        while((temp = fr.read(chars))!= -1) {

            fw.write(chars, 0, temp);
        }
        fw.flush();

    }catch(Exception e) {
        e.printStackTrace();
    }finally {

        try {
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

```

## 六，缓冲流 `bufferedReader`

**起缓冲作用**

**流的分类：根据流出现的位置分：**

+ 包装流（处理流）
+ 节点流

```java
File file = new File("文件名");

//文件字符输入流
FileReader fr = new FileReader(file);

//缓冲区 , 里面放fr ， 里面的流fr叫节点流
//外面的流叫做包装流
BufferedReader br = new BufferedReader(fr);

//三句写到一起
BufferedReader br = new BufferedReader(new FileReader(new File("文件名")));


//操作文件
//开始读 , 每次读一行
String temp = null;

while((temp = br.readLine())!= null){
    //这里必须手动换行。最后会多一个空行。
    System.out.println(temp); // temp就是返回来的读取结果。
}

//关闭流只需要关闭br即可
br.close();
```

```java
Scanner不能接收空格，碰到空格就默认结束。
String name = in.nextLine();
//在源代码中，in其实是一个InputStream，字节流，
```

```java
//br是一个字符流，但是 in是一个字节流，InputStream.
//因此我们嗯需要一个将字节流转化为字符流的东西，也就是转换流。
BufferedReader br = new BufferedReader();

//字节输入流 ------> 字符输入流	InputStreamReader
//字节输出流 ------> 字节输出流	OutputStreamWriter
//不能反过来转换。


//将字节流转化为字符流 InputStream是字节流
InputStreamReader isr = new InputStreamReader(System.in);
//处理字符流。
BufferedReader br = new BufferedReader(isr);

String name = br.readLine();
System.out.println(name);

br.close();
```

## 七，缓冲流 `bufferedWriter`

```java
/*
	1. 因除了文件类的之外，其他的流都不能直接操作文件，故先new一个file，
	2. 之后使用FileOutputStream操作file，
	3. 因为bufferedWriter是一个字符流，故需要将字节流转化为字符流，所以要使用OutputStreamWriter
	4. 最后将转化之后的字符流传入到BufferedWriter中。
*/
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("文件名路径"))));

//分解动作。
File file = new File("文件名");

FileOutputStream fos = new FileOutputStream(file);

OutputStreamWriter osw = new OutputStreamWriter(fos);

BufferedWriter bw = new BufferedWriter(osw);

//直接输出不会换行，那我们需要手动换行
bw.write("xxx!!!");
bw.newLine();
bw.write("xxx!!!");
bw.write("xxx!!!");

bw.flush();

//关流只需要关最外面一层。
bw.close();
```

```java
//案例：copy paste test
BufferedReader br = null;
BufferedWriter bw = null;
try{
    //其中一个环节出了问题，那么都玩不成操作
    br = new BufferedReader(new FileReader("文件路径名1"));
	
    //在FileWriter 里面添加true，就可以追加。
	bw = new BufferedWriter(new FileWriter("文件路径名2",true));
    String name = null;
    
    while((temp = br.readLine) != null){
        bw.write(temp);
        bw.newLine();
    }
    bw.flush();
    
}catch(Exception e){
    e.printStackTrace();
}finally{
    try{
        br.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    try{
        bw.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}

```



```tex
File文件流构造有几种，FileWriter(File file)
    FileWriter(String path);

只要关最外层的处理流，why
自己练习BufferedInputStream和BufferedOutputStream

```

## 七，为什么只需要关闭最外层的处理流

**原理：** 装饰者模式

```java

//不允许更改的方法
//要求对eat方法进行扩展
public class Animal{
    public void eat(){
        System.out.println("这是Animal类的eat方法");
    }
}


//方法1：重写
//但dog必须和Animal之间有关系，必须继承才能够实现。
public class Dog extends Animal{
    
    public void eat(){
        super.eat();
        System.out.println("这是加上的代码");
    }
}
```

**装饰者满足的条件：**

+ 装饰者必须包含被装饰者的引用。
+ 装饰者和被装饰者都必须实现同一接口。

```java
public interface Alive{
    void eat();
}

public class Dog implements Alive {
    
    public void eat(){
        System.out.println("这是加上的代码");
    }
}

//不用继承，不做儿子，也可以实现扩展eat方法
//装饰者模式
//Person是装饰者，Animal是被装饰者
//
public class Person implements Alive{
    //Animal animal; // 这里写Alive 更好
    Alive alive; 
    //面向接口编程
    //Alive alive  = new Animal();
    //Alive alive = new Plants();
    
    public Person( Alive alive){
        this.alive = alive;
    }
    public void eat(){
        alive.eat();
        System.out.println("这是Person加上的代码");
    }
    
}


//测试
public static void main(String [] args){
    Animal animal = new Animal();
    Person p = new Person(animal);
    p.eat();
}
```

**这个案例和流的关系：**

```java
BufferedReader
FileReader

两个类直接间接实现了closable类，都实现了close方法，而且在创建BufferedReader的时候会传入FileReader对象，就相当于上面的类型Person传入Animal，然后使用面向接口编程的思想进行编程。
```

为什么关流只管关掉最外层的

```java
//在外层的close方法调用的时候，传入的对象的close方法也会调用，因此会将节点流的close运行。

public interface Closeable extends AutoCloseable {
       public void close() throws IOException;
}

//BufferedReader
public class BufferedReader extends Reader {
    private Reader in; // 面向接口/抽象编程
    
    
    public BufferedReader(Reader in, int sz) {
        super(in);
        if (sz <= 0)
            throw new IllegalArgumentException("Buffer size <= 0");
        this.in = in; //接收传入的in对象。
        cb = new char[sz];
        nextChar = nChars = 0;
    }
    
    //close 方法
    public void close() throws IOException {
        synchronized (lock) {
            if (in == null)
                return;
            try {
                in.close(); // 调用close方法。
            } finally {
                in = null;
                cb = null;
            }
        }
    }
}


//FileReader
public class FileReader extends InputStreamReader {
    //在InputStreamReader里面实现了close方法，同时也实现了Closable接口
}

//InputStreamReader
public class InputStreamReader extends Reader {
    public void close() throws IOException {
        sd.close();
    }
}


//调用
public static void main(String [] args){
    FileReader fr = new FileReader("E:/a.txt");
    //传入
    BufferedReader br = new BufferedReader(fr);
    
    //调用了br的close，同时也会调用fr的close方法
    br.close();
}
```

## 八，`DataOutputStream` 数据字节输出流

**特点：**

+ 可以将数据带着类型写入文件

**作用：**

+ 可以用于加密解密，文件中是乱码，只有知道输入顺序的人才能够解析出其中的内容

```java
DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:/a.txt"));

//准备数据
byte b = 10;
short s = 11;
int i = 1;
float f = 3.14f;
double d = 3.15;
boolean bo = true;

//写 , 但是写入的数据带类型，因为文件不认识类型，
//所以结果不认识，都是乱码
dos.writeByte(b);

dos.writeShort(s);

dos.writeInt(i);

dos.writeFloat(f);

dos.writeDouble(d);
dos.writeBoolean(bo);

dos.flush();
dos.close();
```

**读取：**

```java
DataInputStream dis = new DataInputStream(new FileInputStream("E:/a.txt"));

//接收数据 , 读的顺序必须和写的顺序一致
//必须提前知道该文件中数据的存储格式，顺序
byte b = dis.readByte();

short s = dis.readShort();

int i = dis.readInt();

float f = dis.readFloat();

double d = dis.readDouble();

boolean bo = dis.readDouble();
```

## 九，打印流

**标准打印流，输出流**

```java
//System.out 是PrintStream类型的。
//打印到控制台上。
PrintStream ps = System.out;
ps.println("xxxxx"); //默认输出到控制台


//可以改变输出方向。
//输出到E:/print.txt
//PrintStream 是管子，而不是其他的东西。
PrintStream ps1 = new PrintStream(new FileOutputStream("E:/print.txt"));

//setout 改变输出方向 , 将System里面的管子out，（默认输出到控制台）改变为管子ps1方向的输出（默认输出到文件）
System.setOut(ps1);

//在使用System.out.println就会输出到指定文件

```

**这个方法可以用于记录日志**

**`PrintWriter` 是没有默认的“管子”的，如果你要输出，就只有自己先指定一个“管子”**



## 十,`ObjectInputStream，反序列化流; ObjectOutputStream`，序列化流

**将java对象序列化到硬盘**

```java
//先来个类，对象
public class Student implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    String name;
    int age;
    public Student(){
        
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "我的名字是"+name+",我今年"+age;
    }
}



ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/A.txt"));

//对象是否能序列化。并不是每一种对象都能序列化。
//想要让某个类的对象可以序列化，则必须让该类实现可序列化接口-----> Serializable    是一个标志接口，是一个标志，不需要实现任何方法，
//还有的接口有：Cloneable，

Student stu = new Student("xxx",25);
oos.writeObject(s);

oos.flush();

oos.close();
```

```java
//反序列化,要先序列化
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/A.txt"));

//使用对象接收
Object o = ois.readObject();
System.out.println(o);
```

```java
//在天猫上购物，每次当你登录上去的时候，你的购物车就从数据库中请求出来显示到你的页面上，但是当你退出时，你的数据就被序列化到数据库中保存起来，以后当你再次登录的时候，你的数据又再次请求过来，这就是序列化与反序列化。当你退出，你的数据就序列化，保存到文件里面。当你登录，你的数据就反序列化反映到你的页面。
//上面的结果也是这样，先序列化，再反序列化，可以输出结果.但是当我们一更改Student类的时候，结果就会报错，这是因为当我们一更改类的时候，系统默认给它的序列号就会改变，因此就不是之前的那个类了，那么输出结果就会报错，一旦改回来了，那么结果也就会正确。为了克服这个缺点，我们一般将徐通的那个变量 serialVersionUID 给固定死了，而且不可更改，也就是常量，那么改变了对象，也不会报错。
```



















































