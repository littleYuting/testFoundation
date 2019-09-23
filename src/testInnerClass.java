public class testInnerClass {
    public static void main(String[] args){
        Outer outer = new Outer();
        testInnerMemberClass(outer);
//        testStaticInnerClass();// 静态内部类必须依赖于外部类的创建
//        testPartInnerClass(outer);
//        testAnonymous();

    }
    public static void testInnerMemberClass(Outer outer){
        /** Summaries
         * 1. 成员内部类不可定义静态变量或方法；
         * 2. 成员内部类对外部类的调用无差别（与修饰无关，private、static 等）；
         * 3. 同名变量，内部调外部直接用 - 类名.this.变量，外部调内部需生成内部对象；
         * 4. 外部非静态类调用内部类，只需直接创建内部类，而外部类静态方法调用内部类，与在外部类访问成员内部类一样；
         */
        Outer.static_value = "smile";
        outer.func3();
        outer.func();
        /**OutPut
         * *************外部类调用成员内部类的成员变量和函数************
         * 成员内部类同名变量: 3， 外部类同名变量: 9
         * 成员内部类生成对外部类的引用：smile
         * *************成员内部类调用外部类的成员变量和函数************
         * 外部类同名变量: 9， 成员内部类同名变量: 3
         * 外部类不同名变量: cyt
         * 外部类静态变量: smile
         * test outer func1
         * test outer func2
         */
    }
    public static void testStaticInnerClass(){
        /**Summaries
         * 1. 静态内部类只能调用外部类的静态成员或变量;
         * 2. 静态内部类自己实现变量或方法定义自由(可用 static 修饰);
         * 3. 静态内部类不可用 private 修饰；
         */
        Outer.static_value = "outer_static_value";
        Outer.func4();
        /**Output
         * *************外部类调用静态内部类的成员变量和函数************
         * 静态内部类同名非静态变量: same_staticValue， 外部类同名静态变量: outer_static_value
         * 直接通过类名调用静态内部类的静态成员变量: StaicInner.cyt
         * *************静态内部类调用外部类的成员变量和函数************
         * 外部类同名静态变量: outer_static_value， 静态内部类同名非静态变量: same_staticValue
         * 静态内部类的静态变量: StaicInner.cyt， 静态内部类的非静态变量: 5
         */
    }
    public static void testPartInnerClass(Outer outer){
        outer.func5("part_value");
    }

    public static void testAnonymous(){
        final int k = 3;
        //创建匿名类的时候，必须实现接口或抽象父类中的所有抽象方法，必要时甚至可以重写父类中的普通方法。
        new Animal() {
            {
                System.out.println("匿名内部类的初始化只能通过代码块(因为匿名所以无构造函数)");
                this.setFood("bambo");
            }
            public void func1(int k){
                System.out.println(this.getFood());
                System.out.println("匿名内部类自定义方法");
                eat(k);
            }
            @Override
            public void eat(int innner_k) {
                System.out.println(innner_k);
            }
        }.func1(k);
        // 继承一个类
//        Thread t = new Thread(){
//            public void run(){
//                for (int i = 0; i <= 10; i++) {
//                    System.out.println(i + " ");
//                }
//            }
//        }.start();
        // 实现一个接口
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 10; i++) {
//                    System.out.println(i + " ");
//                }
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
    }
}
abstract class Animal{
    private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Animal(){}//抽象类可以有构造函数
    public abstract void eat(int k);
    public void play(){
        System.out.println("just have fun");
    }
}
class Outer{
    private int i = 9;
    private String j = "cyt";
//    final Long m = 9L;
    static String static_value;
    public Outer(){}
    public static void func(){
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.outerStaticFunc();
    }
    public static void  func1(){
        System.out.println("test outer func1");
    }
    public void func2(){
        System.out.println("test outer func2");
    }
    public void func3(){
        //外部非静态类调用内部类，只需直接创建内部类，而外部类静态方法调用内部类，与在外部类访问成员内部类一样
        System.out.println("*************外部类调用成员内部类的成员变量和函数************");
        Inner inner = new Inner();
        System.out.println("成员内部类同名变量: " + String.valueOf(inner.i) + "， 外部类同名变量: " + i);
        System.out.println("成员内部类生成对外部类的引用：" + inner.referOuter().static_value);
        inner.innerFun();
    }
    public static void func4(){
        System.out.println("*************外部类调用静态内部类的成员变量和函数************");
        Outer.StaicInner staicInner = new  Outer.StaicInner();
        System.out.println("静态内部类同名非静态变量: " + staicInner.static_value + "， 外部类同名静态变量: " + static_value);
        System.out.println("直接通过类名调用静态内部类的静态成员变量: " + Outer.StaicInner.j);
        staicInner.StaicInnerFun1();
    }
    public void func5(String out_value){
        System.out.println("*************外部类成员函数调用局部内部类************");
        // 局部内部类与成员内部类一样被编译，只是其作用域发生了改变，只能在该方法中被使用
        class PartInner{
            private int inner_i = 2;
            private String j = "partInner_cyt";
//            static int a;//can't define any static variable
            PartInner(String out_value){
                partInnerFunc1(out_value);
            }
            void partInnerFunc1(String out_value){
                System.out.println("外部类同名变量: " + String.valueOf(Outer.this.j) + "， 局部内部类同名变量: " + this.j);
                System.out.println("外部类不同名静态变量: " + static_value); //外部类不同名变量直接获取,此处静态变量未初始化，所以为null；
                System.out.println("外部类的局部变量（即方法内变量）需用 final 修饰: " + out_value);//java 1.8 已智能实现
            }
        }
        new PartInner(out_value);
    }
    private class Inner{//成员内部类可以用 public、private、protected 修饰
        private int i = 3;
//        private static int inner_i;//内部类不能定义静态变量
        int inner_j = 1;
        Inner(){}
        Inner(int i, int inner_j){
            this.i = i;
            this.inner_j = inner_j;
        }
        void dealOuter(){
            System.out.println("*************成员内部类调用外部类的成员变量和函数************");
            // 外部类同名变量可采用 外部类名.this.变量 获取，内部类同名变量可直接获取或通过 this.变量
            System.out.println("外部类同名变量: " + String.valueOf(Outer.this.i) + "， 成员内部类同名变量: " + i);
            System.out.println("外部类不同名变量: " + j); //外部类不同名变量直接获取
            System.out.println("外部类静态变量: " + static_value);
            func1();
            func2();
            //内部类调用外部类的非同名变量或方法，无关修饰，包括 private 、static 等
        }
//        static void innerFun(){ }//内部类不能定义静态方法
        private void innerFun(){
            dealOuter();
        }
        private void outerStaticFunc(){
            System.out.println("外部类静态方法调用内部类需创建外部类，然后再创建内部类");
        }
        private Outer referOuter(){
            return Outer.this;// 创建外部类的引用
        }
    }
    public static class StaicInner{//静态内部类不能用 private 修饰，这点相当于静态变量；
        private int i = 5;
        static String j = "StaicInner.cyt";
        public String static_value = "same_staticValue";
        void StaicInnerFun1(){
            System.out.println("*************静态内部类调用外部类的成员变量和函数************");
            System.out.println("外部类同名静态变量: " + Outer.static_value + "， 静态内部类同名非静态变量: " + static_value);
            System.out.println("静态内部类的静态变量: " + j + "， 静态内部类的非静态变量: " + i);
        }
    }

}