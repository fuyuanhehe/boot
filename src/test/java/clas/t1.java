package clas;


import com.boot.boot.model.user;

public class t1 {

    //  Field[] fields = u.getDeclaredFields(); // 获取字段
    public static void main(String[] args) throws Exception {
     /* System.out.println("\\");  //  \
      System.out.println("\'");  //  '
      System.out.println("\"");  //  "*/
        Class<user> u = user.class;

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
　　　　@Target(ElementType.PACKAGE) ///包


        @Retention 注解的作用
        注解@Retention可以用来修饰注解，是注解的注解，称为元注解。
        Retention注解有一个属性value，是RetentionPolicy类型的，Enum RetentionPolicy是一个枚举类型，
        这个枚举决定了Retention注解应该如何去保持，也可理解为Rentention 搭配 RententionPolicy使用。RetentionPolicy有3个值：CLASS  RUNTIME   SOURCE
        按生命周期来划分可分为3类：
        1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
        2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
        3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
        这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
        那怎么来选择合适的注解生命周期呢？
        首先要明确生命周期长度 SOURCE < CLASS < RUNTIME ，所以前者能作用的地方后者一定也能作用。
        一般如果需要在运行时去动态获取注解信息，那只能用 RUNTIME 注解，比如@Deprecated使用RUNTIME注解
        如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解；
        如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，使用SOURCE 注解。

        注解@Override用在方法上，当我们想重写一个方法时，在方法上加@Override，当我们方法的名字出错时，编译器就会报错
        注解@Deprecated，用来表示某个类或属性或方法已经过时，不想别人再用时，在属性和方法上用@Deprecated修饰
        注解@SuppressWarnings用来压制程序中出来的警告，比如在没有用泛型或是方法已经过时的时候

*/


    }

}
