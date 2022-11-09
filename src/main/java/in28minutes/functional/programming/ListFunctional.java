package in28minutes.functional.programming;

import java.util.List;

public class ListFunctional {
    public static void main(String[] args) {
        printAllNumberInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        //what to do
        numbers.stream()
                .forEach(ListFunctional::print); //method reference
    }

    private static void print(int number){
        System.out.println(number);
    }
}
