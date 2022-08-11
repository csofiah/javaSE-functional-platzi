package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class DemoStreams {

     public static void main(String[] args) {

        List<String> courseList = NombresUtils.getList(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack");

        for(String course: courseList){
            String newCourseName = course.toLowerCase().replace("!", ",");
            System.out.println("Platzi: " + newCourseName);
        }

        Stream<String> courseStream = Stream.of(
                "Java",
                "FrontEnd",
                "Backend",
                "FullStack");

     //  Stream<Integer> courseLengthStream =  courseStream.map(course -> course.length());

    //   Optional<Integer> longest = courseLengthStream.max((x, y) -> y-x);

         //Map hace transformacion y crea un nuevo tipo de stream
       Stream<String> emphasisCourses = courseStream.map(course -> course + "!");
                                                    //filter(Predicate)
       Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
       // emphasisCourses.forEach(System.out::println); //emphasisCourses mo se puede usar porque un stream solo puede ser consumido una sola vez
                                                        //se debe consumir el nuevo stream q se crea, en este caso justJavaCourses
       // justJavaCourses.forEach(System.out::println);

    /*
        //video 24,25
        Stream<String> courseStream2 = courseList.stream();
        addOperator(
        courseStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java"))

         ).forEach(System.out::println);

        //funcion que toma un Stream, agrega sus funciones y devuelve un Stream
        //Ej recibe un stream generado a partir d una base de datos
        //Agrega operaciones para transformarlo de un query a un resultado
        //desp filtran esos datos
        //luego se lo pasen a alguien mas para q transforme esos datos a json
        //para poder responder una peticion web
        static <T> Stream<T> addOperator(Stream<T> stream){
            return stream.peek( data -> System.out::println);
        }*/
    }
}
