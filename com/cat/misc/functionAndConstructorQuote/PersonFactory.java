package com.cat.misc.functionAndConstructorQuote;


@FunctionalInterface
interface PersonFactory<P extends Person>{
    P create(String name, int age);
}

