package commonUtils;

import com.boot.boot.model.User;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Set<String> set = Sets.newHashSet();
        Map<String, Object> map = Maps.newConcurrentMap();

          // 不可变集合
        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3");



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





    }







}
