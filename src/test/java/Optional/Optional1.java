package Optional;

import lambda.Person;

import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Optional1 {

    public static void main(String[] args) {

        // 1、创建一个包装对象值为空的Optional对象
        Optional<String> optEmpty = Optional.empty();
        System.out.println(optEmpty.isPresent());

        // 2、创建包装对象值非空的Optional对象
        Optional<String> optOf = Optional.of("optional------");
        System.out.println(optOf.get());

        // 3、创建包装对象值允许为空也可以不为空的Optional对象
        Optional<String> optOfNullable1 = Optional.ofNullable(null);
        Optional<String> optOfNullable2 = Optional.ofNullable("optional.....");

        //    System.out.println(optOfNullable1.get());
        System.out.println(optOfNullable2.get());

        //    2.4 Optional.ifPresent()方法(判读是否为空并返回函数)
        Person person = new Person();
        person.setAge(2);
        Optional.ofNullable(person).ifPresent(p -> System.out.println("年龄" + p.getAge()));


        //    filter()方法大致意思是，接受一个对象，然后对他进行条件过滤，
        // 如果条件符合则返回Optional对象本身，
        //   如果不符合则返回空Optional Optional.empty
        Person person2 = new Person();
        person2.setAge(22);
        System.out.println("person2----" + Optional.ofNullable(person2).filter(p -> p.getAge() > 50));


        //   map()方法将对应Funcation函数式接口中的对象，
        //  进行二次运算，封装成新的对象然后返回在Optional中 源码：

        Person person3 = new Person();
        person3.setAge(2);
        String optName = Optional.ofNullable(person3).map(p -> person3.getFirstName()).orElse("name为空");

        System.out.println(optName);


        // flatMap()方法将对应Optional< Funcation >函数式接口中的对象，
        //进行二次运算，封装成新的对象然后返回在Optional中 源码:

        Person person4 = new Person();
        Person person5 = new Person();
        person5.setAge(222);
        Optional<Object> optional10 = Optional.ofNullable(person4).map(p -> Optional.ofNullable(p).orElse(person5));


        System.out.println("person4----" + optional10.get());

        // 常用方法之一，这个方法意思是如果包装对象为空的话，
        // 就执行orElse方法里的value，如果非空，则返回写入对象 源码:
        String str = null;

        System.out.println(Optional.ofNullable(str).orElse("bbb"));

        //值依次是分割符 , 前缀  ,后缀
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("xiao");
        stringJoiner.add("zhi");
        System.out.println(stringJoiner.toString());

        StringJoiner sj = new StringJoiner(",");
        IntStream.range(1, 5).forEach(i -> sj.add(i + ""));
        System.out.println(sj.toString());





    }


}
