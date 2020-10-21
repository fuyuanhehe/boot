package Optional;

import lambda.Person;

import java.util.Optional;

public class Optional1 {

    public static void main(String[] args) {

        // 1、创建一个包装对象值为空的Optional对象
        Optional<String> optEmpty = Optional.empty();

        System.out.println(optEmpty);
        // 2、创建包装对象值非空的Optional对象
        Optional<String> optOf = Optional.of("optional");
        System.out.println(optOf);

        // 3、创建包装对象值允许为空也可以不为空的Optional对象
        Optional<String> optOfNullable1 = Optional.ofNullable(null);
        Optional<String> optOfNullable2 = Optional.ofNullable("optional");


        //    System.out.println(optOfNullable1.get());
        System.out.println(optOfNullable2.get());

        //    2.4 Optional.ifPresent()方法(判读是否为空并返回函数)
        Person person = new Person();
        Optional.ofNullable(person).ifPresent(p -> System.out.println("names" + p.getFirstName()));

        Optional.ofNullable(person).ifPresent(p -> System.out.println("年龄" + p.getAge()));
        person.setAge(2);
        Optional.ofNullable(person).ifPresent(p -> System.out.println("年龄" + p.getAge()));



            // 判断是否存在
                  Optional<String> optionalS =  Optional.of("aasd");
                    optionalS.isPresent();




        //    filter()方法大致意思是，接受一个对象，然后对他进行条件过滤，
        // 如果条件符合则返回Optional对象本身，
        //   如果不符合则返回空Optional 源码：

        Person person2 = new Person();
        person2.setAge(200);


        System.out.println(Optional.ofNullable(person2).filter(p -> p.getAge() > 50));


        //   map()方法将对应Funcation函数式接口中的对象，
        //  进行二次运算，封装成新的对象然后返回在Optional中 源码：

        Person person3 = new Person();
        person3.setAge(2);
        String optName = Optional.ofNullable(person3).map(p -> person3.getFirstName()).orElse("name为空");

        System.out.println(optName);


        // flatMap()方法将对应Optional< Funcation >函数式接口中的对象，
        //进行二次运算，封装成新的对象然后返回在Optional中 源码:

        Person person4 = new Person();
        person4.setAge(2);
        Optional<Object> optional10 = Optional.ofNullable(person4).map(p -> Optional.ofNullable(p).orElse(person4));

        System.out.println(optional10.get());

        // 常用方法之一，这个方法意思是如果包装对象为空的话，
        // 就执行orElse方法里的value，如果非空，则返回写入对象 源码:
       /* Person person1 = new Person();*/
       /* person.setAge(2);*/
       /*  Optional.ofNullable(person).orElse(new Person("小明", 2));*/


    }






}
