package com.cat.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxu on 2016/12/1.
 */
public class PermSpaceTest {
    //此段代码在jdk 1.6中会抛出异常，在1.7以及之后会一直运行下去
    //VM args: -XX:PermSize=1M -XX:MaxPermSize=1M
    public static void main(String[] args) {
        //使用list保持对GC root的引用，避免GC回收
        List list = new ArrayList<String>();
        int i = 1;
        for (; ; ) {
            // 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定），则返回池中的字符串。
            // 否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。
//     * When the intern method is invoked, if the pool already contains a
//     * string equal to this {@code String} object as determined by
//     * the {@link #equals(Object)} method, then the string from the pool is
//     * returned. Otherwise, this {@code String} object is added to the
//     * pool and a reference to this {@code String} object is returned.
            list.add(String.valueOf(i++).intern());
            //   System.out.println(i);
        }

    }
}
