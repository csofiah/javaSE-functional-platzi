package com.platzi.functional._18_intermediate_ops;

import com.platzi.functional.model.Developer;
import com.platzi.functional.model.LineItem;
import com.platzi.functional.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_FlatMap_Mkyong {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<Order> orders = findAll();

       // showAllElementsWithoutCharacterA(array);

       // findAllBooks();

        //sumOfOrder(orders);


    }

    private static void sumOfOrder(List<Order> orders) {

        Stream<List<LineItem>> listStream = orders.stream()
                .map(order -> order.getLineItems());

        Stream<LineItem> listLineItem = orders.stream()
                .flatMap(order -> order.getLineItems().stream());

        //T reduce(T identity, BinaryOperator<T> accumulator);
        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())  //  Stream<LineItem>
                .map(lineItem -> lineItem.getTotal())//  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);  //  reduce to sum all

        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                        .map(order -> order.getTotal()) //  Stream<BigDecimal>
                        .reduce(BigDecimal.ZERO, BigDecimal::add);  //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

        if (!sumOfOrder.equals(sumOfLineItems)) {
            System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
        }
    }


    /**
     * This example uses .stream() to convert a List into a stream of objects, and each object contains a set of books, and we can use flatMap to produces a stream containing all the book in all the objects.
     *  we also filter out the book containing the word python and collect a Set to remove the duplicated book.
     */
    private static void findAllBooks() {

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        Set<String> books = list.stream()
                .map(dev -> dev.getBook()) //  Stream<Set<String>>
                .flatMap(x -> x.stream())  //  Stream<String>
                .filter(book -> !book.toLowerCase().contains("python")) //  filter python book
                .collect(Collectors.toSet()); //  remove duplicated

        books.forEach(System.out::println);

    }

    private static void showAllElementsWithoutCharacterA(String[][] array) {

        // array to a stream
       // Stream<String[]> stream1 = Arrays.stream(array);

        List<String> elements = Stream.of(array)   //Stream<String[]>
                .flatMap(Stream::of)             // Stream<String>
                .filter(x -> !"a".equals(x))     // filter out the a
                .collect(Collectors.toList());  // return a List

        elements.forEach(System.out::println);
//b
//c
//d
//e
//f
    }


    // create dummy records
    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }
}
