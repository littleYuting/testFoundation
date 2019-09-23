import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class testKeyFinal {
    private final int a = 3;
    private String b = "variable";
    private Person p1 = new Person("normal_person");
    private final Person p2 = new Person("final_person");
    private int[] arr_1 = {1,2,3,4,5};
    private final List<Integer> arr_2 = Arrays.asList(9,8,7,6);
    private static final double VALUE_ONE = 3.1415926;

    public static void main(String[] args){
        testFinalData();
        testKeyFinal.SubClass.testFinalMemberFun();
    }

    public static void testFinalData(){
        testKeyFinal finalData = new testKeyFinal();
        //*------------------------基础类型测试--------------------------*
//        finalData.a = 10; 常量，无法修改
        finalData.b = "cyt";
        System.out.println("final 作用于 基础数据类型：" + String.valueOf(finalData.a) + " 、"+finalData.b);
        //*------------------------对象类型测试--------------------------*
        finalData.p1 = new Person("normal_cyt");
        finalData.p2.setName("update_final_person");
        System.out.println(finalData.p1.getName() + " " + finalData.p2.getName());
//        finalData.p2 = new Person("final_cyt"); // final 型对象引用不可修改，但是其引用的值如果不是final型可以修改；
        //*------------------------数组类型测试--------------------------*
        finalData.arr_1 = new int[2];
//        finalData.arr_2 = new int[10]; // 数组是一种特殊的对象类型
        List<Integer> new_arr_2 =  finalData.arr_2.stream().map(x -> x+1).collect(Collectors.toList());
        System.out.println(new_arr_2);

    }
    public static final void testFinalClass(){
        System.out.println("父类的final方法");
    }
    public static void testFinalMemberFun(){
        System.out.println("父类的非final方法 testFinalClass");
    }

    static class SubClass extends testKeyFinal{
        public static void testFinalMemberFun(){
            System.out.println("父类的 static final 变量：" + VALUE_ONE);
            System.out.println("继承类可以重写父类的非final方法 testFinalClass");
        }
//        public static void testFinalClass(){} //继承类不能重写父类的final方法
    }
//    static class subClass1 extends FinalClass{
//
//    }//final 类不能被继承，final 的成员方法没有机会被覆盖，默认都是 final 的
}
final class FinalClass{
    void func(){
        System.out.println("hello");
    }
}