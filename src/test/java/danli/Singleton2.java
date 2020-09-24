package danli;

public class Singleton2 {

    // 4.静态内部类
    private static class Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {}

    public static final Singleton2 getInstance() {
        return Holder.INSTANCE;
    }
}
