package test;

import com.boot.boot.model.User;

public class IntegerDui {
    public static void main(String[] args) {

        //  -129 < Integer < 128  有效
        Integer a1 = 127;
        Integer b1 = Integer.valueOf(127);
        System.out.println("1："+(a1 == b1));

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println("2："+(a2 == b2));

        Integer a3 = 128;
        Integer b3 = 128;
        System.out.println("3："+(a3 == b3));

        Integer a4 = -128;
        Integer b4 = -128;
        System.out.println("4："+(a4 == b4));


        User q1 = new User();
        User w1 = new User();
        User c1 = q1;

        System.out.println(q1 == w1);
        System.out.println(q1.equals(w1) );

        System.out.println(q1 == c1);
        System.out.println(q1.equals(c1) );

    }
}
