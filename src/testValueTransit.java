public class testValueTransit {
    public static void main(String[] args){
//        caseOneMain();
//        caseTwoMian();
        caseThreeMian();
    }

    public static void caseOneMain(){
        int num1 = 3, num2 = 5;
        System.out.println("num1 = " + String.valueOf(num1) + " , num2 = " + String.valueOf(num2));
        oneSwap(num1, num2);
    }
    public static void oneSwap(int num1, int num2){
        int tmp;
        tmp = num1;
        num1 = num2;
        num2 = tmp;
        System.out.println("num1 = " + String.valueOf(num1) + " , num2 = " + String.valueOf(num2));
    }
    public static void caseTwoMian(){
        Person p = new Person("cyt");
        System.out.println("original name is : " + p.getName());
        System.out.println("point new person : " + twoUpdate(p).getName());
        System.out.println("updated name is : " + p.getName());
    }
    public static Person twoUpdate(Person p1){
        p1.setName("beauty");
        p1 = new Person("zgx");
        return p1;
    }
    public static void caseThreeMian(){
        Person p1 = new Person("cyt");
        Person p2 = new Person("zgx");
        threeSwap(p1, p2);
        System.out.println("p1's name is " + p1.getName() + " , p2's name is  " + p2.getName());

    }
    public static void threeSwap(Person p1, Person p2){
        Person p;
        p = p1;
        p1 = p2;
        p2 = p;
        System.out.println("p1's name is " + p1.getName() + " , p2's name is  " + p2.getName());
    }
}

