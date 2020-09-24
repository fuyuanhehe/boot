package test;

public class objDui {

    public static void main(String[] args) {

        String str1 = "hello";
         String str2 = "hello";
        String str3 = new String("hello");
        String str4 = str2;

         System.out.println(str1 == str2);
         System.out.println(str1.equals(str2));

        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

        System.out.println(str1 == str4);
        System.out.println(str1.equals(str4));

       /* 对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；

　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

　　对于equals方法，注意：equals方法不能作用于基本数据类型的变量

　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。*/

    }

}
