package clas;

import java.lang.reflect.Method;

public  class MethodTest
{
    public static void main(String[] args)
    {
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
