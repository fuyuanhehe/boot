package test;

public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}
 class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
 class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
 class NotInitialization {
    public static void main(String[] args) {
        // 例子1.通过子类引用父类的静态字段，不会导致子类初始化
        System.out.println(SubClass.value);
        System.out.println("------------------");
        // 例子2.通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] sca = new SuperClass[10];
        System.out.println("------------------");
        // 例子3.常量在编译阶段会存入调用类的常量池中，本质上并没有直接
        // 引用到定义常量的类，因此不会触发定义常量的类的初始化。
        System.out.println(ConstClass.HELLOWORLD);
    }
}
