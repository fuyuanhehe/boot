package danli;

public class Singleton {

    // 3.双重检测机制
    private volatile static Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
