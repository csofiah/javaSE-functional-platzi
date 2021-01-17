package com.platzi.functional.triFunction;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface TrinaryOperator extends TriFuncional{

    public static void main(String[] args) {
        TriFuncional<Integer, Integer, Integer, Double> calculatePromedio =
                (n1, n2, n3) -> {
                    return Double.valueOf(n1 + n2 + n3 /3);
                };
        System.out.println("calculatePromedio ".concat(String.valueOf(calculatePromedio.apply(10,10,10))));


        Function<Integer, String> addZero = x -> x <10? "0"+x : String.valueOf(x);

        TriFuncional<Integer,Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" + addZero.apply(month) + "-" + addZero.apply(day));
        System.out.println("Fecha: " + parseDate.apply(2020,11,01));

        TriFuncional<Integer,Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(10,10,1992));
    }

}
