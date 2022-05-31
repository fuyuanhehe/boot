package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {

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

        System.out.println("fangfa 333");

        List<String> list3 = Arrays.asList(str);
        boolean contains = list3.contains("s");
        System.out.println(contains);
     //   list3.remove(1);
        System.out.println(list3);

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
    }
}

