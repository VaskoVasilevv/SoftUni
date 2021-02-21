package Generics.Ex.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> box = new ArrayList<>();
        while (n-- > 0){
            box.add(new Box<>(Double.parseDouble(scanner.nextLine())));

        }
        Box<Double> compare = new Box<>(Double.parseDouble(scanner.nextLine()));

        System.out.println(findAllOccurrences(box,compare));
    }

    private static<T extends Comparable<T>> long findAllOccurrences(List<Box<T>> boxes, Box<T> box) {


       return  boxes.stream().filter(b-> 0 < b.getElement().compareTo(box.getElement()))
        .count();



    }
}
