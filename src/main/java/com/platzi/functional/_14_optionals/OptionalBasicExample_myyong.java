package com.platzi.functional._14_optionals;

import java.util.Optional;

public class OptionalBasicExample_myyong {

    public static void main(String[] args) {
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
