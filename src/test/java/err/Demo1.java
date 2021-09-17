package err;

/**
 * 抛出异常的代码是放在 try 中
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            print();
        } catch (Exception e) {

            System.out.println("打印抛出异常");
        }
        System.out.println("程序结束");
    }

    private static void print() {


        for (int i = 0; i < 10; i++) {
            try {

                System.out.println("正常流程" + i);
                if (i == 5) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("运行异常");
            }

        }


    }
}