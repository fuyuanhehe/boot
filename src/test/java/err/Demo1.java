package err;

/**
 * 抛出异常的代码是放在 try 中
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            print();
         //   Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("打印抛出异常");
        }
        System.out.println("程序结束");
    }

    private static void print() {
        int index = 0;
        while (index < 15) {
            try {
                Thread.sleep(10);
                ++index;
                System.out.println("index = " + index);
                if (index == 5 ) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("循环抛出异常");
            }

        }
        System.out.println("循环结束");
    }
}