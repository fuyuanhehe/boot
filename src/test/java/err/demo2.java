package err;

public class demo2 {


    public static void main(String[] args) {


        for (int i = 0; i <  5; i++) {
            System.out.println("运行iiiiiiii---"+i);

            try {

                xxx(i);

            } catch (Exception e) {
                System.out.println("异常iiiiiiii---"+i);

                continue;
            }

            System.out.println("运行xxxxxxx---"+i);


        }

    }


    public static void xxx(int i) throws Exception {

        if( i == 2){
            throw new Exception("err");
        }


    }


}
