package err;

public class demo3 {


    public static void main(String[] args) {

        for (int i = 0; i < 2 ; i++) {

            System.out.println("外城---"+i);

            for (int j = 0; j <  3; j++) {

                System.out.println("内城---"+j);
                 if( j == 1){
                     break;
                 }

            }

            System.out.println("外城-xxxxx--"+i);


        }


    }


}
