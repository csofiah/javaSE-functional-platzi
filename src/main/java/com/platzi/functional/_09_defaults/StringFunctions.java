package com.platzi.functional._09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperation{
        int getAmout();

        default void operate(String text){
            int x = getAmout();
            while(x --> 0){
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface DoOperation{
        void take(String text);

        //podria tener un metodo por defaul t q haga la conexion de la base datos
        default void execute(int x, String text){
            while(x --> 0){
                take(text);
            }
        }
    }
    public static void main(String[] args) {
        StringOperation six = () -> 6;
        six.operate("Alumno");

        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "texto");
    }
}
