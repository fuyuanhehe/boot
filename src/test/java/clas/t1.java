package clas;


import com.boot.boot.model.User;

public class t1 {

    //  Field[] fields = u.getDeclaredFields(); // 获取字段
  public static void main(String[] args) throws Exception{
     /* System.out.println("\\");  //  \
      System.out.println("\'");  //  '
      System.out.println("\"");  //  "*/
        Class<User> u = User.class;

        //  System.out.println(u.getSimpleName()); //User
       // System.out.println(u.getName()); //com.boot.boot.model.User
      //  System.out.println(u.getCanonicalName()); //com.boot.boot.model.User
      /*  Field[] fields = u.getDeclaredFields(); // 获取字段  getFields这个方法只返回public得
        for (Field f :fields) {
            System.out.println(f.getName()); // username
            System.out.println(f.getType().getSimpleName()); // string

            if(f.getAnnotation(OperLogging.class) != null){
                System.out.println(f.getAnnotation(OperLogging.class).content());
            }
        }*/

    /*    Method[] f2 = u.getMethods();
        for (Method f :f2) {
           // System.out.println(f.getName());
            if(f.getAnnotation(OperLogging.class) != null){
                System.out.println(f.getAnnotation(OperLogging.class).content());
            }
        }*/

       // @Retention(RetentionPolicy.RUNTIME) @OperLogging
      //  @Target({ElementType.TYPE, ElementType.METHOD,ElementType.FIELD})
  /*  　@Target(ElementType.TYPE)   //接口、类、枚举、注解
　　　　@Target(ElementType.FIELD) //字段、枚举的常量
　　　　@Target(ElementType.METHOD) //方法
　　　　@Target(ElementType.PARAMETER) //方法参数
　　　　@Target(ElementType.CONSTRUCTOR)  //构造函数
　　　　@Target(ElementType.LOCAL_VARIABLE)//局部变量
　　　　@Target(ElementType.ANNOTATION_TYPE)//注解
　　　　@Target(ElementType.PACKAGE) ///包   */



    }

}
