package com.cat.misc.functionAndConstructorQuote;

public class MethodQuote {
    public static void main(String[] args) {
        //三种形式 简单明了  对象::方法 是我们要强调的
        //可以引用静态方法 比如 Integer::parseInt 或者下方的对象/方法
        IConvert<Integer,String> case1 = new IConvert<Integer, String>() {
            @Override
            public Integer convert(String string) {
                return Integer.parseInt(string);
            }
        };
        IConvert<Integer,String> case2 = (string -> Integer.parseInt(string));
        IConvert<Integer, String> case3 = Integer::parseInt;
        Integer result = case3.convert("123");
        System.out.println(result);

        //调用对象的普通方法 定义
        Person person = new Person();
        //我们可以看到IConvert中第二个String(类型)是后面方法的返回值,要匹配functional interface中的方法的参数
        //第一个String(类型)在本例中是返回的参数
        IConvert<String, String> a = person::test;

        //通过工厂来新建对象
        PersonFactory<Person> factory = Person::new;
        Person p = factory.create("Jack",34);

    }
}
