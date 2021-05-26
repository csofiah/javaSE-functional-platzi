package com.platzi.functional._04_functional;

import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 1;
        isEven.test(4);

        Predicate<Student> isApproved = student -> student.getCalificacion() > 6.0;

        Student juan = new Student(5.9);
        System.out.println(isApproved.test(juan));
    }


    static class Student{
        private double calificacion;

        public Student(double calificacion){
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }
}
