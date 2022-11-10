package in28minutes.functional.programming;

import java.util.List;

public class ListStructured {

    public static void main(String[] args) {
        //printAllNumberInListStructures(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumberInListStructures(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printEvenNumberInListStructures(List<Integer> numbers) {
        for(int number:numbers){
            if(number % 2 == 0)
                System.out.println(number);
        }
    }

    private static void printAllNumberInListStructures(List<Integer> numbers) {
        //How to loop the numbers
        for(int number:numbers){
            System.out.println(number);
        }
    }
}
