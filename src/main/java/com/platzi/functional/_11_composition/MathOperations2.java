package com.platzi.functional._11_composition;

import java.util.function.Function;

public class MathOperations2 {

    public static void main(String[] args) {
        Function<Integer, Integer> multipluby3 = x -> {
            System.out.println("Multiplicando x: " + x + " por 3"); //paso 3
            return x * 3;
        };

        Function<Integer, Integer> add1MultiplyBy3 = multipluby3.compose( y -> { //2 primero ejecuta la operacion mas uno
                                                                                  //luego este va a llamar a multipluby3
            System.out.println("le agregare 1 a: " + y);
            return y +1;
        });

        Function<Integer, Integer> andSquare = add1MultiplyBy3.andThen( y -> {  //1 andSquare llama add1MultiplyBy3
            System.out.println("Estoy elevendo : " + y + " al cuadrado");    //paso 4 por ultimo ejecuta y*y
            return y +y;
        });

        //primero se ejecuta la lamda y luego se ejecuta
        //la funcion sobre la cual se mando a llamar
        //se agregan pasos antes de la ejecucion de la funcion
        System.out.println(
                add1MultiplyBy3.apply(5)
        );

        System.out.println(
                andSquare.apply(3)
        );
    }
}
