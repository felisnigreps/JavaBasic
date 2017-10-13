package com.cat.misc.annotation;

//调用注解并赋值
@MyAnnotation(metaAnnotation = @MetaAnnotation(birthday = "我的出身日期为1988-2-18"), color = "red", array = {23, 26})
public class AnnotationTest {
    public static void main(String[] args) {
        //检查类AnnotationTest是否含有@MyAnnotation注解
        if (AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
            //若存在就获取注解
            MyAnnotation annotation = (MyAnnotation) AnnotationTest.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation);
            //获取注解属性
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            //数组
            int[] arrs = annotation.array();
            for (int arr : arrs) {
                System.out.println(arr);
            }
            //枚举
            Gender gender = annotation.gender();
/*
            Java programming language enum types are much more powerful than their counterparts in other languages.
            The enum declaration defines a class (called an enum type). The enum class body can include methods and other
            fields. The compiler automatically adds some special methods when it creates an enum. For example,
            they have a static *values* method that returns an array containing all of the values of the enum in the order
            they are declared.
            简单来说,没有values方法是因为这个方法是在编译期生成的 所以我们看不到. 使用javap可以看到values方法
        ➜  annotation javap Gender.class
            Compiled from "Gender.java"
              public abstract class com.cat.misc.annotation.Gender extends java.lang.Enum<com.cat.misc.annotation.Gender> {
              public static final com.cat.misc.annotation.Gender MAN;
              public static final com.cat.misc.annotation.Gender WOMAN;
              public static com.cat.misc.annotation.Gender[] values();
              public static com.cat.misc.annotation.Gender valueOf(java.lang.String);
              public abstract java.lang.String getName();
              com.cat.misc.annotation.Gender(java.lang.String, int, com.cat.misc.annotation.Gender$1);
              static {};
                }



            而且他是隐式java.lang.Enum,根据java单继承的特性 枚举不能继承其他类
*/
            for (Gender i : Gender.values()) {
                System.out.println(i);
            }
            System.out.println(Gender.valueOf("MAN"));

            System.out.println("性别为：" + gender);
            //获取注解属性
            MetaAnnotation meta = annotation.metaAnnotation();
            System.out.println(meta.birthday());
        }
    }
}