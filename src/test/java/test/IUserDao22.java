package test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 接口
public interface IUserDao22 {
    void save();
    void find();
    void find2(int i);
}

//目标对象
class UserDao implements IUserDao22{

    @Override
    public void save() {
        System.out.println("模拟： 保存用户！");
    }

    @Override
    public void find() {
        System.out.println("查询");
    }

    @Override
    public void find2(int i) {
        System.out.println(i);
    }
}

/**
 * 动态代理：
 * 代理工厂，给多个目标对象生成代理对象！
 *
 */
class ProxyFactory {

    // 接收一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回对目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance() {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 目标对象使用的类加载器
                target.getClass().getInterfaces(),   // 目标对象实现的所有接口
                new InvocationHandler() {            // 执行代理对象方法时候触发

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {

                        // 获取当前执行的方法的方法名
                        String methodName = method.getName();
                        // 方法返回值
                        Object result = null;
                        if ("find".equals(methodName)) {
                            // 直接调用目标对象方法

                            result = method.invoke(target, args);
                        } else {
                            System.out.println("开启事务...");
                            // 执行目标对象方法
                            System.err.println(args);
                            result = method.invoke(target, args);
                            System.out.println("提交事务...");
                        }
                        return result;
                    }
                }
        );
        return proxy;
    }
}