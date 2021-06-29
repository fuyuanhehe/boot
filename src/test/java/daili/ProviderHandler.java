package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProviderHandler implements InvocationHandler {
    Object target;

    public Object bind(Object target) {
        this.target = target;
        //这里生成了代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //限流
     //   flowLimit(args);

        System.out.println(proxy.getClass().getSimpleName());
        System.out.println(method.getName());
        System.out.println(args[0]);  // aaa
        Object obj = method.invoke(target, args);
        //打印日志
        System.out.println("log");
        return obj;
    }


    //main
    public static void main(String[] args) throws Exception {
        ProviderHandler providerHandler = new ProviderHandler();
        IProvider iProvider = (IProvider) providerHandler.bind(new SimpleProvider());
        iProvider.getData("aaa");

    }

}