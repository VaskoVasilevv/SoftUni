package Exam.P26Oct2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Stack
        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(male::push);
        //Queue
        ArrayDeque<Integer> female = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int matches= 0;
        while (!male.isEmpty() && !female.isEmpty()){
            int m = male.peek();
            int f = female.peek();

            if (m <= 0 || m % 25 == 0){
                male.pop();
                continue;
            }
            if (f <= 0 || f % 25 == 0){
                female.poll();
                continue;
            }
            if (m == f){
                matches++;
                male.pop();
                female.poll();
            }else {
                female.poll();
                male.push(male.pop() -2);
            }

        }
        System.out.println("Matches: "+ matches);
        System.out.println(male.isEmpty() ? "Males left: none"
                : String.format("Males left: %s",male.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(female.isEmpty() ? "Females left: none"
                :String.format("Females left: %s",female.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
}
