package compose;

import java.util.function.Function;

public class Compose {
    public static void main(String[] args) {
        Function<Integer, Integer>  multiplyBy3 = x ->{
            System.out.println("Multiplicando x: " + x +  " por 3");
            return x *3;
        };

        Function<Integer, Integer>  add1MultiplyBy3 =
            multiplyBy3.compose(y -> {
                System.out.println("Le agregue 1 a:" + y);
                return y + 1 ;
            });

        System.out.println("1.se ejecuta la lambda");
        System.out.println("2. se ejecuta MultiplyBy3");
            System.out.println(add1MultiplyBy3.apply(5));

        Function<Integer, Integer> andSquare =
                add1MultiplyBy3.andThen(x ->{
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                });
        System.out.println("para q ejecute otra funcion despues se utiliza andThen");
        System.out.println(andSquare.apply(3));
        System.out.println("1. andSquare llama a add1MultplyBy3");
        System.out.println("2.add1MultplyBy3 llama a multiplyBy3");
        System.out.println("3.multiplyBy3 va a llamar esta lambda");
        System.out.println("4.se jecuta el codigo multiplyBy3");
        System.out.println("4.regresa a andSquare y ejecutara ese codigo");


    }
}
