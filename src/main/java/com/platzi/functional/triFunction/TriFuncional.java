package com.platzi.functional.triFunction;

@FunctionalInterface
public interface TriFuncional<T,U,P,R> {

    R apply (T t,U u ,P p);
}
