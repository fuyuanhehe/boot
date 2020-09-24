package xmls;

import com.boot.boot.config.SpringUtil;
import com.boot.boot.model.User;
import com.boot.boot.model.u2;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class t1 {

  /*  public static void main(String[] args) {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try
        {
            Resource res = resolver.getResource("classpath:spring-shiro.xml");
            BeanFactory bf = new XmlBeanFactory(res);//生成BeanFactory，此时并没有将conf.xml中的bean放置到容器中。
            User car01 = (User) bf.getBean("users22");//从conf.xml中获取到Id为temp的bean，此时才开始装载。

            System.out.println(car01);

        }
        catch(Exception e)
        {
            System.out.println("Exception: "+String.valueOf(e));
        }

    }*/

    public static void main(String[] args)   {
        try {
            //方法1：类路径
            ApplicationContext act = new ClassPathXmlApplicationContext("spring-shiro.xml");
            User car01 = (User) act.getBean("users22");//从conf.xml中获取到Id为temp的bean，此时才开始装载。

            System.out.println(car01);

          //  String a = User.class.getClassLoader().getResource("").getPath();
          //  System.out.println(a);

            SpringUtil springUtil = new SpringUtil();

            //System.out.println(springUtil.getApplicationContext().getBean(UserService) );

            //System.out.println(  );
        } catch (Exception e) {
            e.printStackTrace();
        }


        Box box2 = new Box();
        box2.set(new User());
        User apple = (User) box2.get();


        Box<User> box = new Box<>();
        User a = box.get();

        /////////////////////

        User u1 = new User();
        u2 u2 = new u2();


        ArrayList<? super  User> al = new ArrayList<>();
          al.add(u1);
        al.add(u2);

     //   泛型的限定：
//    ? extends E:接收E类型或者E的子类型。
//    ? super E:接收E类型或者E的父类型



        List<User> list2 = new LinkedList<>();
        List<u2> liasd1st2 = new LinkedList<>();

        get2(list2);


    }

     public static List<? extends User> get2(List<? extends User> list){

        return list;
     }


    public static T get222(Class<T>  a) {

     //   User people = (User) Class.forName("com.boot.boot.model.User").newInstance();
       // T xx = a.newInstance();

        T ax = null;
        try {
            ax = a.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return ax;
    }



}
