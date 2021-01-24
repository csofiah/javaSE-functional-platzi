package com.platzi.functional._06_reference_operator;

import javax.xml.transform.sax.SAXSource;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("44gatos","dinosaurios", "perro");

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("//////");
        profesores.forEach(System.out::println);
    }

   public  static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
