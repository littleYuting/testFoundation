public class testEquals {

    public static void main(String[] args){
        testEquals();
    }
    public static void testEquals(){
        // 对比 == 与 equals
        String a = new String("cyt");//引用
        String b = new String("cyt");//引用
        String c = "cyt";//字符串常量
        String d = "cyt";
        if (a == b) { System.out.println("a == b"); }//false 对比的是两个对象的地址
        if (a.equals(b)) { System.out.println("a equals b"); }//true
        if (c == d) { System.out.println("c == d"); }//true
        if (c.equals(d)) { System.out.println("c equals d"); }//true

        Person p1 = new Person("cyt");
        Person p2 = new Person("cyt");
        if (p1 == p2) { System.out.println("p1 == p2"); }//false
        if (p1.equals(p2)) { System.out.println("p1 equals p2"); }//无重写equals方法时,为false，否则，为true
        /**
         * 总结
         * == 比较的是两个对象的地址， equals 方法可放宽 == 的要求，自定义两个对象相同的条件；
         * 常量池中同名常量只存在一个，堆中同内容的对象可有多个，对应不同的地址；
         * String类 的 equals方法被重写过，对比的是对象的内容
         */
    }
}
class Person{
    private String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object p){
        if (p instanceof Person) {
            if (this.getName().equals(((Person) p).getName())) {
                return true;
            }
        }
        return false;
    }
}
