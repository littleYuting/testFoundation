1. 面向对象和面向过程的区别
- 一般来讲，面向过程性能较高，面向对象易维护、复用、扩展；
- java性能差的主要原因是 java 本身的语言特性（半编译）
![java语言编译](https://pic3.zhimg.com/80/45e5e8e74ed0fec7c782e30ac8c4edd7_hd.jpg) ![jvm](https://pic3.zhimg.com/80/b8934c347bde7fe377644fa78537cae0_hd.jpg)
- 补充：
    - [解释性语言和编译型语言区别](https://www.iteye.com/blog/rednaxelafx-492667)；
    - jvm 是运行java字节码的虚拟机，目的是实现一次编译结果，可运行在不同系统（==平台无关性==），生成相同的二进制机器码；
    - java 可移植性：每种基本类型所占存储空间的大小不会随着机器硬件架构的变化而变化（也与 jvm 相关）
    - JDK：创建 + 编译程序(javac、javadoc、jdb) + 包含 JRE-运行程序 （jvm、java类库、java命令、其他基础构件）； 

2. java 和 c++ 的区别
- 面向对象,支持封装、继承、多态；
- 程序内存安全：java 不提供通过指针直接访问内存；
- 类继承：java 类单继承（接口多继承）， c++ 类多继承；
- 内存管理机制：java 自动，c++ 需手动释放；

3. 字符型常量 和 字符串常量 的区别
- 形式：字符型常量-单引号+一个字符，字符串常量-双引号+多个字符；
- 含义：字符型常量相当于整型值，可直接参与运算，字符串常量代表该字符串在内存中的地址值；
- 占存：字符型常量-2个字节，字符串常量-多个字节；

4. 构造器 Constructor 不能被 override （无继承），但可以 overload；  
- 补充：override 与 overload 的区别：
    - overload：同类，方法名相同，参数（类型、个数、顺序）、返回值和访问修饰符可不同，发生在编译时；
    - override：父子类，方法名、参数相同，返回值和抛出范围不大于父类，访问修饰符不小于父类，private 父类不可 overload；

5. String、StringBuffer、StringBuilder 的区别
- 共同点：使用字符数组保存字符串；
- 可变性：String 用 final 修饰字符数组，StringBuffer、StringBuilder 无；
- 线程安全性：String（不变性）、StringBuffer（同步锁） 线程安全，StringBuilder 非线程安全；
- 性能：高->低（StringBuffer > StringBuilder > String(update 时 新对象，改引用)）
- 补充：final 关键字 [详见](https://blog.csdn.net/andie_guo/article/details/12885885)
    - 修饰变量：初始化后，基本数据类型的变量不能修改，引用类型的变量不能指向另一个对象；
    - 修饰类：类不能继承，其所有成员方法被隐式地被指定为 final；
    - 修饰方法：1）防止继承类修改该方法（类中所有 private 方法都隐式地指定为 final）；
    - 注意：父类的private成员方法不能被子类方法覆盖，其默认是final类型；

6. java 中无参&无实现构造方法的作用
- 执行子类构造方法前，若没有用super()来调用父类特定的构造方法，则会调用父类中无参的构造方法；  
7. import java 和 javax 的区别
- 现已均是标准 java API 的组成部分，无区别；
8. 成员变量与局部变量的区别
- 语法形式:成员变量属于类,局部变量是在方法中定义的变量或是方法的参数；
- 修饰符：只有成员变量可被 public,private,static 等修饰，成员变量和局部变量都能被 final 所修饰；
- 存储：有static修饰的成员变量属于类，否则属于实例（堆内存），局部变量（栈内存）；
- 生存周期：成员变量随着对象的创建而存在，局部变量随着方法的调用而自动消失；
- 初值：成员变量有自动默认值（ final 修饰的成员变量必须显式赋值），局部变量需手动赋值；

9. 对象实体与对象引用的区别
- 一个对象引用可以指向0个或1个对象，一个对象可以有n个引用指向它；
10. 静态方法和实例方法的区别
- 外部调用：类名 or 对象.静态方法，对象.实例方法；
- 内部调用：静态方法 -> 静态成员变量 or 方法；
11. == 与 equals 的区别
- == :基本数据类型比较值，引用数据类型比较内存地址；
- equals: 类无override equals()，等价于“==”，否则以 equals() 方法比较两个对象相等；
12. hashCode() 与 equals()
- 判断重复：先判断 hashCode 是否相同，若相同则调用 equals()方法，若两个对象相等,则equals方法返回true；
- hashcode 相同是对象相同的必要不充分条件；
- equals 方法被覆盖，则 hashCode 方法也必须被覆盖；

13. Java 无引用传递，只有值传递：
- 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）；
- 一个方法可以改变一个对象参数的状态；
- 一个方法不能让对象参数引用一个新的对象；
14. 线程的生命周期  
- 创建之后，线程处于 NEW 状态;
- 调用 start() 方法后开始运行，线程这时候处于 READY（可运行） 状态;
- 可运行状态的线程获得了 cpu 时间片（timeslice）后就处于 RUNNING（运行） 状态;
- 执行 wait()方法后，线程进入等待状态，需依靠其他线程的通知才能够返回到运行状态
    - TIME_WAITING(超时等待) 状态相当于在等待状态的基础上增加了超时限制，比如通过 sleep（long millis）方法或 wait（long millis）方法，当超时时间到达后 Java 线程将会返回到 RUNNABLE状态。当线程调用同步方法时，在没有获取到锁的情况下，线程将会进入到 BLOCKED（阻塞） 状态。
- 执行 Runnable 的run()方法之后将会进入到 TERMINATED（终止） 状态。

15. static 关键字
- 静态成员变量和成员方法：属于类，被类的所有对象共享，一般通过类名调用；
- 静态代码块：定义在类中方法外,执行顺序：静态代码块（只执行一次）—>非静态代码块—>构造方法（后两个在生成新对象自动调用）；
- 静态内部类： 创建不依赖于外围类，不能使外围类的非static成员变量和方法；
- 静态导包：import static + 指定类，直接导入静态资源，无需通过类名调用静态成员； 
- 补充：
    - [java 常见代码块的作用与区别](https://blog.csdn.net/Dustin_CDS/article/details/79143760)
    - [内部类学习](https://www.cnblogs.com/chenssy/p/3388487.html)

16. 内部类
- 特性：
-     1、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立；

      2、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类（解决继承类和接口时的命名冲突，或实现多继承）；

      3、创建内部类对象的时刻并不依赖于外围类对象的创建（静态内部类）；

      4、内部类并没有令人迷惑的 “is-a” 关系，ta 就是一个独立的实体；

      5、内部类提供了更好的封装，除了该外围类，其他类都不能访问；
- 优势：
    - 可访问外部类的私有成员（属性、方法）；
    - 用内部类定义在外部类中不可访问的属性，在外部类中实现比外部类的 private 更小的访问权限；
    - 注：内部类是一个编译时的概念，一旦编译成功，就会成为两个完全不同的类；
- 分类：成员内部类、局部内部类、[匿名内部类](https://www.cnblogs.com/chenssy/p/3390871.html)、静态内部类；
- 静态内部类之外，成员内部类与局部内部类需满足：
    - 不能存在任何 static 的变量和方法；[why](https://blog.csdn.net/qq_32575047/article/details/78793591) 【生命周期不一致】  
    - 依附于外围类，只有创建外围类后才能创建内部类；
    - 内部类对外部类的调用无差别，即与修饰无关，包括 private 、 static 等；
    - 内部类调用外部类变量、方法：同名下采用类名.this.变量/方法，不同名直接调用；
    - 外部类调用内部变量、方法：
        - 外部类的非 static 方法：创建 内部类对象；
        - 外部类的 static 方法：与在外部类访问成员内部类一样，需先创建一个外部类，再创建内部类；
- 静态内部类的限制：只能调用外部类的静态属性和方法；
- 匿名内部类的特性 [详见](https://www.cnblogs.com/chenssy/p/3390871.html)
    - 非抽象，使用匿名内部类时只能继承一个类或实现一个接口；
    - 不能定义构造函数，使用构造代码块初始化匿名内部类；
    - 包含于局部内部类，受其所有限制，其中 [方法传递到内部类的形参必须是 final 类型](https://blog.csdn.net/jiao_zg/article/details/78911469)，jdk 1.8 已智能实现；；
    - 匿名内部类只能使用一次；
    - 常用于 多线程；

