package com.platzi.functional._18_intermediate_ops;

import com.platzi.functional.model.Developer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_FlatMap_Mkyong {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

       // showAllElementsWithoutCharacterA(array);

        findAllBooks();
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
}
