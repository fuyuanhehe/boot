package lambda;

/**
 * @author Alin
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        // Using anonymous innerclass
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // Using lambda expression
        new Thread(() -> System.out.println("Hello world 2!")).start();

        // Using anonymous innerclass
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world3 !");
            }
        };

        // Using lambda expression
        Runnable race2 = () -> System.out.println("Hello world4 !");


         new Thread(

         ).start();

        // Run em!
        System.out.println("-----");
        race1.run();
        race2.run();
    }

}
