package com.cat.misc;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by xugenli on 2017/7/31.
 */
public class BasicContainerDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("rick");
        list1.add("morty");
        list1.add("jerry");
        list1.add("summer");

        //这里的size是逻辑长度,并不是数组长度. 10空间,占了1个,那么size就是1,下面的数据才是数组长度
        System.out.println(list1.size());
        System.out.println(list2.size());
        Field al = ArrayList.class.getDeclaredField("DEFAULT_CAPACITY");
        al.setAccessible(true);
        System.out.println("通过反射得到的数组长度" + al.get(list1));
        //System.arraycopy(old,0,new,0,10); 数组拷贝native方法,记得用.
        System.out.println(list1);
        list1.remove(1);
        list1.remove("summer");

        System.out.println(list1);

        TreeMap<String, Integer> cache = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = o2.compareTo(o1);
                System.out.println(o2 + "-" + o1 + "的差值:" + a);
                return a;
            }
        });

        cache.put("12", 1);
        cache.put("a", 2);
        cache.put("3", 3);
        cache.put("b", 2);
        System.out.println("TreeMap" + cache);

        LinkedHashMap<String,String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("c","1");
        linkedMap.put("a","1");
        linkedMap.put("bc","1");
        linkedMap.put("dcs","1");
        System.out.println(linkedMap);
       
    }
}
