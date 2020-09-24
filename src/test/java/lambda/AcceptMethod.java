package lambda;

import com.boot.boot.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcceptMethod {


    public static void main(String[] args) {
        List<User>  userList = new ArrayList<>();

          User u = new User();
          u.setId(55);

        User u2 = new User();
        u2.setId(12);

        User u21 = new User();
        u21.setId(99);

          userList.add(u);
        userList.add(u2);
        userList.add(u21);

       // userList.forEach( User::getUsername );
        User comparator = new User();
     //   userList.sort( comparator );
    //    Collections.sort( userList, comparator );

   //     Collections.sort(userList,comparator.thenComparingInt(value -> value.getId()));
        userList.forEach(m-> System.out.println(m.getId() ));

        Collections.sort(userList, (s1, s2) -> s1.getId().compareTo(s2.getId())   );
       userList.forEach(m-> System.out.println( m.getId()));


    }



}
