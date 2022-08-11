package com.platzi.functional._15_streams_intro;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsWithCollectors_Mkyong {

    //https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");

        groupAndCountElements(fruits);
    }

    private static void groupAndCountElements(List<String> fruits) {

        Map<String, Long> groupMap = fruits.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );

        System.out.println(groupMap);

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        groupMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
    }
}
