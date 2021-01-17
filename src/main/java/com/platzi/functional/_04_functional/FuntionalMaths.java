package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class FuntionalMaths {
    public static void main(String[] args) {
        System.out.println("Hola Platzi");

        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };
        System.out.println(square.apply(5));

        Function<Integer, Boolean> isOdd = x -> x%2 ==1;

        Predicate<Integer> isEven  = x -> x%2 == 0;
        isEven.test(4);

        Predicate<Student> isApproved = student -> student.getCalificacion() > 6.0;
        Student luis = new Student(7);
        System.out.println(isApproved.test(luis));
    }
    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }


    }

}

