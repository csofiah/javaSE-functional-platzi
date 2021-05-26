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

        //los dos argumentos mas la salida van hacer del mismo tipo
        BinaryOperator<Integer> add = (nro1, nro2) -> nro1 + nro2;
        System.out.println("Sumar: " + add.apply(5,1));

        //recibe string, el nro de espacios y devuelve un entero
        BiFunction<String, Integer, String> lefpad =
                (text, number)  -> String.format("%" + number + "s", text);
        System.out.println("Prueba " + lefpad.apply("Java",2));


    }
}
