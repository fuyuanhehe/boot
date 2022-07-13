package test;

public class ArrayToList {


    public static final ThreadLocal<Boolean> stringThreadLocal = new ThreadLocal<>();

/*
    public static void main(String[] args) {

        //数组转list
        String[] str = new String[] {"hello","world"};

        //方式二：
        List<String> list2 = Arrays.asList(str);
        System.out.println(list2);

        //方式三：
        //同方法二一样使用了asList()方法。这不是最好的，
        //因为asList()返回的列表的大小是固定的。
        //事实上，返回的列表不是java.util.ArrayList类，而是定义在java.util.Arrays中一个私有静态类java.util.Arrays.ArrayList
        //我们知道ArrayList的实现本质上是一个数组，而asList()返回的列表是由原始数组支持的固定大小的列表。
        //这种情况下，如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。
        //java.util.Arrays.ArrayList类具有 set()，get()，contains()等方法，但是不具有添加add()或删除remove()方法,所以调用add()方法会报错。


        System.out.println("fangfa 444");
        //方式四：使用Collections.addAll()
        List<String> list4 = new ArrayList<>(str.length);
        Collections.addAll(list4, str);
        System.out.println(list4);

        //方式五：使用Stream中的Collector收集器
        //转换后的List 属于 java.util.ArrayList 能进行正常的增删查操作
        System.out.println("fangfa 555");
        List<String> list5 = Stream.of(str).collect(Collectors.toList());
        System.out.println(list5);



        System.out.println("fangfa 66");
        List<String> asdaz = new ArrayList<>();
        asdaz.add("刘雯");
        asdaz.add("杨紫");
        asdaz.add("胡歌");
        String [] strings =  asdaz.toArray( new String[]{});
        System.out.println(Arrays.toString(strings));//[刘雯, 杨紫, 胡歌]
    }*/

    public static void main(String[] args) throws Exception {

     //   stringThreadLocal.set(Boolean.TRUE);

     //   System.out.println( stringThreadLocal.get());
        stringThreadLocal.remove();
        stringThreadLocal.set(true);

           System.out.println( stringThreadLocal.get());
           System.out.println( ArrayToList.stringThreadLocal.get());

    /*    if(BooleanUtils.isTrue(stringThreadLocal.get())){
            System.out.println(2222);

        }else {
            System.out.println(3);

        }*/

        /*创建两个线程*/
     /*   for (int i = 0; i < 15; i++) {
            Thread.sleep(500);
            int a = i;
            new Thread(
                    () -> {
                        Double d = Math.random() * 10;
                        *//*存入当前线程独有的值*//*
                      //  stringThreadLocal.set(d.intValue() + "");
                        new A().get(a);
                        new B().get(a);
                    }
            ).start();
        }*/

    }


    static class A {
        public void get(int i) {
            /*取得当前线程所需要的值*/
            System.out.println(i + "AAAA---" + stringThreadLocal.get());
        }
    }

    static class B {
        public void get(int i) {
            /*取得当前线程所需要的值*/
            System.out.println(i + "BBBB--" + stringThreadLocal.get());
        }

    }
}

