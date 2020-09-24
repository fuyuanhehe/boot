package lambda;

import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleMapping {

    // 分组
        public static void main(String[] args) {
            List<Person> personList = Lists.newArrayList();

            Person p2 =  new Person();
            p2.setJob("BB");
            Person p =  new Person();
            p.setJob("AA");
            Person p3 =  new Person();
            p3.setJob("DD");
            personList.add(p2);
            personList.add(p);
            personList.add(p3);

             personList.forEach( System.out::println);

            //分组
           Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getJob()));
            System.out.println(collect);




        }
    }


