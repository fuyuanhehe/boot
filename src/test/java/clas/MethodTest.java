package clas;

import com.boot.boot.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public  class MethodTest
{
    public static void main(String[] args)
    {

        ApplicationContext act = new ClassPathXmlApplicationContext("spring-shiro.xml");
        User car01 = (User) act.getBean("users22");//从conf.xml中获取到Id为temp的bean，此时才开始装载。

        System.out.println(car01);


        String [] names ={"tom","tim","allen","alice"};
    //    Class<?> clazz = MethodTest.class;
        try
        {
            MethodTest ss = (MethodTest) Class.forName("clas.MethodTest").newInstance();

            System.out.println(ss.getClass().getSimpleName());
                   ////  ===下面
            MethodTest m = new MethodTest();

            Class<?> a = m.getClass();
            Class<?> c = MethodTest.class;

            Object d = c.newInstance();

            Object x = c.getDeclaredConstructor().newInstance();

             /////////////

            Method method = a.getMethod("sayHi", String.class);

            for(String name : names)
                method.invoke(m,name);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

        public static void sayHi(String name)
        {
            System.out.println("Hi "+name);
        }

}
