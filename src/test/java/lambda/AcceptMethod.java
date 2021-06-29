package lambda;

import com.boot.boot.model.User;
import org.assertj.core.util.Lists;

import java.util.*;

public class AcceptMethod {


    public static void main(String[] args) {
        List<User> userList = new LinkedList<>();
        User u = new User();
        u.setUsername("b");
        u.setId(55);


        User u2 = new User();
        u2.setId(12);
        u2.setUsername("a");

        User u21 = new User();
        u21.setId(99);
        u21.setUsername("c");

        userList.add(u);
        userList.add(u2);
        userList.add(u21);


        //大 到 小
        Collections.sort(userList, (s1, s2) -> s2.getUsername().compareTo(s1.getUsername()));

        System.out.println(userList);

        // 小 到  大
        Collections.sort(userList, (s1, s2) -> s1.getUsername().compareTo(s2.getUsername()));

        System.out.println(userList);


        Map<String, String> map = new HashMap<>();
        map.put("2", "ccccc");
        map.put("4", "aaaaa");
        map.put("1", "bbbbb");
        map.put("9", "ddddd");

        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (s1, s2) -> s2.getKey().compareTo(s1.getKey()));

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

        List<Person> personList = Lists.newArrayList();

        Person p2 = new Person();
        p2.setAge(1);
        p2.setJob("BB");

        Person p = new Person();
        p.setAge(3);
        p.setJob("AA");

        Person p3 = new Person();
        p3.setAge(2);
        p3.setJob("DD");

        Person p4 = new Person();
        p4.setAge(2);


        personList.add(p2);
        personList.add(p);
        personList.add(p3);
        personList.add(p4);
        //     personList.forEach( System.out::println);

        //分组
        //  Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getJob()));
        //  System.out.println(collect);

        //   List<String> c2 = personList.stream().map(a -> a.getJob() + ",").collect(Collectors.toList());


    }


}
