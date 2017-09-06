package com.cat.misc.functionAndConstructorQuote;

@FunctionalInterface
public interface IConvert<F, T> {
    F convert(T t);
}
