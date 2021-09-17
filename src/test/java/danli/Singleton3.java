package danli;

import java.util.Date;

public class Singleton3 {
    // 创建私有静态实例，意味着这个类第一次使用的时候就会进行创建
    private static Singleton3 instance = new Singleton3();


    // 首先，将 new Singleton() 堵死
    private Singleton3() {
        System.out.print(111);
    }

    public static Singleton3 getInstance() {

        return instance;
    }

    // 瞎写一个静态方法。这里想说的是，如果我们只是要调用 Singleton.getDate(...)，
    // 本来是不想要生成 Singleton 实例的，不过没办法，已经生成了
    public static Date getDate(String mode) {
        return new Date();
    }




}