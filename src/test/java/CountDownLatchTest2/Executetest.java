package CountDownLatchTest2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
@Slf4j
public class Executetest {

    public  static  int num = 0;

    public static void main(String[] args) throws Exception {

        num = 1;
            CompletableFuture.runAsync(
                    () -> {
                        try {
                            t1();
                        } catch (Exception e) {
                            num = 2;
                        }
                    }
            );

            Thread.sleep(2000);
        System.out.println(num);

    }




    public static void t1() throws Exception {

        if(true){
            throw new  Exception();
        }

    }






}
