import static java.lang.Math.*; // 直接导入指定 Math 中的静态成员，无需通过类名调用

public class testKeyStatic {

    public static void main(String[] args){
        testStatic();
    }

    public static void testStatic(){
        // 关键字 static 用法
        // One : 静态成员变量、成员方法
        Student.classNum = 2;
        for (int i = 0; i < 3; i++) {
            Student s = new Student(String.valueOf(i));
            s.sayHello(s);
            Student.classNum += i;
            System.out.println(s);
        }
        System.out.println("final classNum : " + Student.classNum);
        Student.sayHello();
        /**总结 1：
         *  属于类，共享,静态成员变量不能用 private 修饰；
         */
        //Two : 静态代码块
        /**总结 2：
         * 定义：可定义多个，可放在类成员方法外的任意位置；
         * 执行：仅执行一次，执行优先顺序为静态代码块>普通代码块>构造函数(普通代码块和构造函数会随生成对象执行多次)，同级按定义顺序执行;
         * 可为静态成员变量赋值，但不能访问；
         * 代码块的一般作用是对类的一些 static 变量进行赋值，常用于不需要创建对象就可以调用类中的方法；
         */
        // Three ： 静态内部类(对比非静态 内部类进行学习)
        Student.displayInnerClass();
        /**总结 3：
         * 静态内部类的创建不依赖于外围类，内部不能使用外围类的非 static 成员变量和方法；
         * 外围类可直接调用其静态成员变量或方法，可通过实例化静态内部类获取其非静态成员；
         */
        // Four : 静态导包
        System.out.println("test 静态导包， 调用 Math 中的 max 函数： max（123， 4） = " + String.valueOf(max(123,4)));

    }
}
class Student{
    static {
        System.out.println("just test 静态代码块 start");
    }
    static {
        classNum = 2;
        System.out.println("just test 静态代码块 sleep");
//        System.out.println(classNum); // 只可以对静态成员变量赋值，不可以访问
    }
    static class Learn{
        public static String course = "Java";
        public String flag = "hard";
        public void disPlay(){
            System.out.println(classNum);//可直接访问外部内的静态成员变量
            Student.sayHello();
            System.out.println(new Student("cyt").getName()); // 因为新建对象 cyt ，所以会调用普通代码块
        }
    }
    class Play{
//        public static String fun = "singing"; // 不能定义静态变量
        public void disPlay(){
            System.out.println(classNum); //可调用外围类的任何成员
            System.out.println(name);
            sayHello();
        }
    }

    private String name;//非静态成员变量不能被静态代码块访问
    static Integer classNum; // 不能用private
    public Student() {}
    {
        System.out.println("just test 普通代码块");
    }
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void sayHello(Student s){
        System.out.println("Just test static function: " + classNum + ", name = " + s.getName());
    }
    public static void sayHello(){
        System.out.println("Just test static function: " + classNum);
    }
    public static void displayInnerClass(){
        System.out.println("**********************************");
        System.out.println("test staticInnerClass : "  + Learn.course);//不能直接调用静态内部类的非静态变量,需实例化new Learn().flag
        new Learn().disPlay();
        System.out.println("**********************************");
        System.out.println("test normalInnerClass" );
        Play play = new Student().new Play();// 必须通过外围类定义,此处生成了一个空对象，依然会调用普通代码块，而且name=null
        play.disPlay();
    }
    @Override
    public String toString(){
        return "the student's name is " + this.name + " , and the total classNum ： " + classNum;
    }
    static {
        System.out.println("just test 静态代码块 end");
    }
}