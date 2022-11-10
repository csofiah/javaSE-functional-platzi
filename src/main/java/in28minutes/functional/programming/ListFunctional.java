package in28minutes.functional.programming;

import java.util.List;

public class ListFunctional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

       // printAllNumberInListFunctional(numbers);
       // printEvenNumberInListStructures(numbers);
        //printOddNumberInListStructures(numbers);
       // printSquaresOfEvenNumberInListStructures(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API","Microservices",
                "AWS","PCF", "Azure", "Docker", "Kubernetes");

       // printOnlySpringCourses(courses);
       // printOnlyNameCoursesHasMoreThan4Letters(courses);
        printNumberOfCharacters(courses);

    }

    private static void printNumberOfCharacters(List<String> courses) {
        courses.stream()
                .map(course -> course.length())
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumberInListStructures(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number %2 ==0)//par
                .map(number -> number*number)
                .forEach(System.out::println);
    }

    private static void printOnlyNameCoursesHasMoreThan4Letters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::println);
    }

    private static void printOnlySpringCourses(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printOddNumberInListStructures(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 !=0)
                .forEach(System.out::println);
    }

    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        //what to do
        numbers.stream()
                .forEach(System.out::println); //method reference
                //.forEach(ListFunctional::print); //method reference
    }

    private static void printEvenNumberInListStructures(List<Integer> numbers) {
        numbers.stream()
                //.filter(ListFunctional::isEven)
                .filter(number -> number%2 ==0)//lamdba expresion
                .forEach(System.out::println); //method ref
    }

    private static boolean isEven(int number){
        return number % 2 == 0;
    }
    private static void print(int number){
        System.out.println(number);
    }
}
