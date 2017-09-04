package com.cat.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamList {
    public static void main(String[] args) {
        //流的生成方法
        Stream stream = Stream.of('a', 'b', 'c');
        String[] strings = new String[]{"a", "b", "c"};
        stream = Stream.of(strings);
        List<String> list1 = Arrays.asList(strings);
        //使用map操作可以遍历集合中的每个对象，并对其进行操作，map之后，用.collect(Collectors.toList())会得到操作后的集合。
        list1 = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        //平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(nums);

        //过滤空的元素
        List<String> emptyCheck = Arrays.asList("ss", "dg", "", "ls");
        emptyCheck = emptyCheck.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(emptyCheck);

        //如果只是想对流中的每个对象进行一些自定义的操作，可以使用forEach
        emptyCheck.stream().forEach(s -> System.out.println(s + "G"));

        //limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素:
        List<String> alpha = Arrays.asList("a", "b", "c", "c", "d", "feg", "e", "g");
        System.out.println(alpha.stream().skip(2).limit(3).collect(Collectors.toList()));

        //排序
        System.out.println(alpha.stream().sorted().parallel().collect(Collectors.toList()));

        //找出长度最大的string
        System.out.println(alpha.stream().mapToInt(s -> s.length()).max().getAsInt());

        //去重
        System.out.println(alpha.stream().distinct().collect(Collectors.toList()));

        //match
        //allMatch：Stream 中全部元素符合传入的 predicate，返回 true
        //anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
        //noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
        System.out.println(alpha.stream().anyMatch(s -> s.equals("c")));
        System.out.println(alpha.stream().allMatch(s -> s.equals("c")));
        System.out.println(alpha.stream().noneMatch(s -> s.equals("c")));

        List list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            list.add(Math.random() * 1000);
        }


        long start = System.nanoTime();
        //2183401
        list.stream().sorted().sequential();
        //2473676
        list.stream().sorted().parallel();

        long end = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toNanos(end - start));


    }


}
