package commonUtils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class commonFile {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(5);
//获取并集
        Collection<Integer> unionList = CollectionUtils.union(list, list2);
        System.out.println(unionList);

//获取交集
        Collection<Integer> intersectionList = CollectionUtils.intersection(list, list2);
        System.out.println(intersectionList);

//获取交集的补集
        Collection<Integer> disjunctionList = CollectionUtils.disjunction(list, list2);
        System.out.println(disjunctionList);

//获取差集
        Collection<Integer> subtractList = CollectionUtils.subtract(list, list2);
        System.out.println(subtractList);
    }

}
