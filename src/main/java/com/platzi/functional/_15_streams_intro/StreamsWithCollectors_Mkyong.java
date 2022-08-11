package com.platzi.functional._15_streams_intro;

import com.platzi.functional.model.Item;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsWithCollectors_Mkyong {

    //https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");

       // groupAndCountElements(fruits);

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

      //  groupByNameAndSumQty(items);

        groupByPriceAndGroupNewCollectionByPrice(items);
    }

    private static void groupByPriceAndGroupNewCollectionByPrice(List<Item> items) {

        Map<BigDecimal, List<Item>> prices = items.stream().collect(
            Collectors.groupingBy(Item::getPrice)
        );
        System.out.println(prices);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result = items.stream().collect(
            Collectors.groupingBy(Item::getPrice,
                    Collectors.mapping(Item::getName, Collectors.toSet()))
        );
        System.out.println(result);
        //{19.99=[banana], 29.99=[orang, watermelon], 9.99=[papaya, apple]}
    }

    private static void groupByNameAndSumQty(List<Item> items) {
        Map<String, Long> countingItems = items.stream().collect(
                        Collectors.groupingBy(Item::getName,Collectors.counting())
                );
        System.out.println(countingItems);

        //sum qty
        Map<String, Integer> sum = items.stream().collect(
            Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty))
        );

        System.out.println(sum);
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
