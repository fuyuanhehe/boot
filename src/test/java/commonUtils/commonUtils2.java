package commonUtils;

import com.boot.boot.model.User;
import com.google.common.base.Joiner;
import com.google.common.collect.*;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.lang.reflect.Field;
import java.util.*;

public class commonUtils2 {


    public static void main(String[] args) {

        Field[] fields = FieldUtils.getAllFields(User.class);

       /* for (Field field : fields) { // 获取所有得字段
         //   System.out.println(field.getName());

        }*/

        //获取类的全名称
        String a = ClassUtils.getName(User.class);
       // System.out.println(a);
            // New 各种对象
      //  List<String> list = Lists.newArrayList();
      //  Set<String> set = Sets.newHashSet();
      //  Map<String, Object> map = Maps.newConcurrentMap();

          // 不可变集合
        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3");


//返回两个字段
        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "yideng");
        System.out.println(pair.getLeft() + "," + pair.getRight()); // 输出 1,yideng
// 返回三个字段
        ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "yideng", new Date());
        System.out.println(triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight()); // 输出 1,yideng,Wed Apr 07 23:30:00 CST 2021

        String str = StringUtils.repeat("ab", 2);
        System.out.println(str); // 输出abab


        String str2 = "yideng";
        String capitalize = StringUtils.capitalize(str2);
        System.out.println(capitalize); // 输出Yideng


      //  DateUtils.parseDate()


        //列表转符号分隔的字符串
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String result = Joiner.on("-").join(list);

      //  System.out.println(result);  //  1-2-3


        // 求交集、并集、差集等
       // 例如下面代码求 set1 和 set2 的交集
        Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer> set2 = Sets.newHashSet(1,2,3,4,7);


        Sets.SetView<Integer> result1 = Sets.union(set1, set2);//合集，并集 1, 2, 3, 4, 5, 6, 7

        Sets.SetView<Integer> result2 = Sets.intersection(set1, set2);//交集

        Sets.SetView<Integer> result3 = Sets.difference(set1, set2);//差集 1中有而2中没有的


      /*  List<String> list = Lists.newArrayList();
        List<Integer> list = Lists.newArrayList(1, 2, 3);
// 反转list
        List<Integer> reverse = Lists.reverse(list);
        System.out.println(reverse); // 输出 [3, 2, 1]
// list集合元素太多，可以分成若干个集合，每个集合10个元素
        List<List<Integer>> partition = Lists.partition(list, 10);

*/


        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("key", 1);
        map.put("key", 2);
        Collection<Integer> values = map.get("key");
        System.out.println(map); // 输出 {"key":[1,2]}
// 还能返回你以前使用的臃肿的Map
        Map<String, Collection<Integer>> collectionMap = map.asMap();


        // 一批用户，同时按年龄和性别分组
        Table<Integer, String, String> table = HashBasedTable.create();
        table.put(18, "男", "yideng");
        table.put(18, "女", "Lily");
        System.out.println(table.get(18, "男")); // 输出 yideng
// 这其实是一个二维的Map，可以查看行数据
        Map<String, String> row = table.row(18);
        System.out.println(row); // 输出 {"男":"yideng","女":"Lily"}
// 查看列数据
        Map<Integer, String> column = table.column("男");
        System.out.println(column); // 输出 {18:"yideng"}



        BiMap<String, String> biMap = HashBiMap.create();
// 如果value重复，put方法会抛异常，除非用forcePut方法
        biMap.put("key","value");
        System.out.println(biMap); // 输出 {"key":"value"}
// 既然value不能重复，何不实现个翻转key/value的方法，已经有了
        BiMap<String, String> inverse = biMap.inverse();
        System.out.println(inverse); // 输出 {"value":"key"}



        Multiset<String> multiset = HashMultiset.create();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("orange");
        System.out.println(multiset.count("apple")); // 输出 2
// 查看去重的元素
        Set<String> set = multiset.elementSet();
        System.out.println(set); // 输出 ["orange","apple"]

// 还能手动设置某个元素出现的次数
        multiset.setCount("apple", 5);

        Iterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }







}
