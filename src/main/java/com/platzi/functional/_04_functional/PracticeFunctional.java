package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class PracticeFunctional {

    public static void main(String[] args) {

        //Functional
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };
        System.out.println(square.apply(5));

        Function<Integer, Boolean> isOdd = x -> x%2 ==1;
        System.out.println(" Function<Integer, Boolean> " + isOdd.apply(2));

        Predicate<Integer> isEven  = x -> x%2 == 0;
        isEven.test(4);

        Predicate<FuntionalMaths.Student> isApproved = student -> student.getCalificacion() > 6.0;
        FuntionalMaths.Student luis = new FuntionalMaths.Student(7);
        System.out.println(isApproved.test(luis));

    }
}
