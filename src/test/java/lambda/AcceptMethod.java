package lambda;

import com.boot.boot.model.User;

import java.util.LinkedList;
import java.util.List;

public class AcceptMethod {


    public static void main(String[] args) {
        List<User> userList = new LinkedList<>();
        User u = new User();
        u.setUsername("测试啊");
        u.setId(35);


        User u2 = new User();
        u2.setId(15);
        u2.setUsername("测试啊2");

        User u21 = new User();
        u21.setId(25);
        u21.setUsername("真的啊啊");

        User u3 = new User();
        u3.setId(22);
        u3.setUsername("阿阿不");


        userList.add(u);
        userList.add(u2);
        userList.add(u21);
        userList.add(u3);




        //   IntSummaryStatistics intSummaryStatistics = userList.stream().mapToInt(User::getId).summaryStatistics();
        //    System.out.print(intSummaryStatistics);

     /*   List<User> xx = userList.stream().sorted(Comparator.comparing(User::getUsername)
                .thenComparing(User::getId)).collect(Collectors.toList());

        xx.stream().forEach(System.out::println);

*/

       /* Collections.sort(userList, new Comparator<User>() {

            Collator collator = Collator.getInstance(Locale.CHINA);
            @Override
            public int compare(User o1, User o2) {
                CollationKey key1 = collator.getCollationKey(o1.getUsername());
                CollationKey key2 = collator.getCollationKey(o2.getUsername());
                return key2.compareTo(key1);
            }
        });

        userList.stream().forEach(System.out::println);*/


        // Map<Integer, String> x = userList.stream().collect(Collectors.toMap(User::getId, User::getUsername));

        //大 到 小
        //  Collections.sort(userList, (s1, s2) -> s2.getUsername().compareTo(s1.getUsername()));
        //  System.out.println(userList);

        // 小 到  大
        //  Collections.sort(userList, (s1, s2) -> s1.getUsername().compareTo(s2.getUsername()));
        // System.out.println(userList);


        // List<User> userList1 = userList.stream().sorted(Comparator.comparing(User::getUsername)).collect(Collectors.toList());
        //  userList1.stream().forEach(System.out::println);


        //  Map<String, List<User>> rs = userList.stream().collect(Collectors.groupingBy(User::getUsername));
     /*   Map<String, String> map = new HashMap<>();
        map.put("2", "ccccc");
        map.put("4", "aaaaa");
        map.put("1", "bbbbb");
        map.put("9", "ddddd");

        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (s1, s2) -> s2.getKey().compareTo(s1.getKey()));

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }*/


    }


}
