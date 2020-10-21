package Optional;

import lambda.Person;

public class test {

    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("a");

        Person person1 = new Person();
        person1.setFirstName( new String("a") );

        System.out.println(  person == person1);


        System.out.println(  person.equals(person1));

     //   System.out.println( person.getFirstName().equals(person1.getFirstName() )  );



        System.out.println( person.getFirstName() == (person1.getFirstName() )  );

        String a = "aa";

        String b = "aa";



        String c = "a";

        String d = c + "a";


        System.out.println( a == d);

    }


}
