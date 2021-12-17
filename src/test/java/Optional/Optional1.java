package Optional;

import lambda.Person;

import java.util.Optional;

public class Optional1 {

    public static void main(String[] args) throws Exception {


        //    2.4 Optional.ifPresent()方法(判读是否为空并返回函数)
        Person person = new Person();
        person.setAge(555);

        Optional.ofNullable(person).ifPresent(p ->
                person.setAge(998)
        );

        System.out.print(person);

        Object xx = Optional.ofNullable(person).map(Person::getAge).orElseThrow(() -> new Exception("取指错误"));
        System.out.print(xx);


        Object a = Optional.ofNullable(person).map(Person::getFirstName).orElse("xx");

        System.out.print(a);


        //值依次是分割符 , 前缀  ,后缀
   /*     StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("xiao");
        stringJoiner.add("zhi");
        System.out.println(stringJoiner.toString());

        StringJoiner sj = new StringJoiner(",");
        IntStream.range(1, 5).forEach(i -> sj.add(i + ""));
        System.out.println(sj.toString());*/


    }


}
