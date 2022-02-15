package test;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class lt {

    private static final Map<String, Funne> funnelMap = new HashMap<>();

    static {
        Funne funne = new Funne();
        funne.setCount(100);
        funne.setRemain(100);
        funne.setTime(System.currentTimeMillis());
        funnelMap.put("funne", funne);
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {

            int finalI = i;
            new Thread(
                    () -> {
                        try {
                            mainTest(finalI);
                        } catch (InterruptedException e) {
                        }
                    }
            ).start();


        }


    }


    private static void mainTest(int i) throws InterruptedException {
        Funne funne = funnelMap.get("funne");
        System.out.print("我是任务" + i);
        System.out.print("\n");
        funne.isTrue();
    }


    @Data
    private static class Funne {
        int adopt = 1;
        private long count;
        private long remain;
        private long time;

        private synchronized boolean isTrue( ) {
            long timeMillis = System.currentTimeMillis();
            int remainTime = (int) ((timeMillis - time) / 1000);
            if (remainTime >= 1) {
                int num = remainTime * adopt;

                if (num + remain >= count) {
                    remain = count;
                } else {
                    remain = remain + num;
                }
                time = System.currentTimeMillis();
            }
            if (remain <= 0) {
                System.out.print("失败====" + false);
                System.out.print("\n");
                return false;
            }
            remain--;
            System.out.print("==========剩余-->" + remain + "====" + true);
            System.out.print("\n");
            return true;
        }


    }


}
