package com.platzi.functional._15_streams_intro;

import com.platzi.functional.model.Person;

import java.util.Arrays;
import java.util.List;

public class StreamExample_myyong {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        //Person result = getStudentByName(persons, "jack");
        Person result = getPersonByName(persons,"jack");
        System.out.println(result);

        Person result2 = getPersonByName(persons,"jackxxx");
        System.out.println(result2);

        Person result3 = getPersonByNameAndAge(persons,"jack", 22);
        System.out.println(result3);

        Person result4 = getPersonByNameAndAge(persons,"jack", 20);
        System.out.println(result4);

        String result5 = getPersonByNameAndUpperCase(persons,"jack");
        System.out.println(result5);
    }

    private static String getPersonByNameAndUpperCase(List<Person> persons, String name) {
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .map(person -> person.getName().toUpperCase())
                .findAny()
                .orElse("");
    }

    private static Person getPersonByName(List<Person> persons, String name) {
       return persons.stream()
               .filter(person -> person.getName().equals(name))
               .findAny() // If 'findAny' then return found
               .orElse(null); // If not found, return null
    }

    private static Person getPersonByNameAndAge(List<Person> persons, String name, int age) {
     return persons.stream()
             .filter(person -> person.getName().equals(name) && person.getAge()==age )
             .findAny()
             .orElse(null);
    }

    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}
