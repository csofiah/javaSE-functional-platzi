package com.platzi.functional._14_optionals;

import java.util.Optional;

public class OptionalBasicExample_myyong {

    //https://mkyong.com/java8/java-8-optional-in-depth/
    public static void main(String[] args) {

      //  optionalBasicExample();
      //  optionalMapFlapMapExample();
      //  optionalFilterExample();
      //  optionalIfPresentExample();
        optionalOrElseExample();
    }

    private static void optionalOrElseExample() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        System.out.println(gender.orElse("NA"));
        System.out.println(emptyGender.orElse("NA"));

        System.out.println(gender.orElseGet(() -> "NA"));
        System.out.println(emptyGender.orElseGet(() -> "NA"));


    }

    private static void optionalIfPresentExample() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if(gender.isPresent())
            System.out.println("value is " + gender.get());
        else
            System.out.println("value is not available");

        gender.ifPresent(g -> System.out.println("gender is available"));
        emptyGender.ifPresent(g -> System.out.println("no imprime nada"));
    }

    private static void optionalFilterExample() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //filter on Optional
        System.out.println(gender.filter(g -> g.equals("male")));
        System.out.println(gender.filter(s -> s.equalsIgnoreCase("male")));
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE")));
    }

    private static void optionalMapFlapMapExample(){

        Optional<String> nonEmptyGender2 = Optional.of("female");
        Optional<String> emptyGender2 = Optional.empty();

        System.out.println("Nom empty Optional " + nonEmptyGender2.map(String::toUpperCase));
        System.out.println("Empty Optional " + emptyGender2.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender2 = Optional.of(Optional.of("male"));
        System.out.println("Optional value " + nonEmptyOptionalGender2);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender2.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatmap " + nonEmptyOptionalGender2.flatMap(gender -> gender.map(String::toUpperCase)));


    }

    private static void optionalBasicExample() {
        Optional<String> gender = Optional.of("male");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional: " + gender);
        System.out.println("Non-Empty Optional: Gender value " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        //java.lang.NullPointerException
        // System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

        //--------------------------------------
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> nonEmptyGender2 = Optional.of("male");

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value :: "+ nonEmptyOptionalGender);
        // System.out.println("Optional.map :: "+ nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        // System.out.println("Optional.flatmap :: "+ nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
    }
}
