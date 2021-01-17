package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text +  "\"";
        UnaryOperator<String> addMark = text ->  text +  "!";

        System.out.println(quote.apply("Hola estudiante de platzi"));
        System.out.println(addMark.apply("Hola Luis Alberto"));

        BinaryOperator<Integer> add = (nro1, nro2) -> nro1 + nro2;
        System.out.println("Sumar: " + add.apply(5,1));

        BiFunction<String, Integer, String> lefpad =
                (text, number)  -> String.format("%" + number + "s", text);
        System.out.println("Porque no come Luis Alberto " + lefpad.apply("Java",2));

        System.out.println("porque no hace las tarea luis alberto");
    }
}
