package Exam.P19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Stack
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        //Queue
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int leftFlowers = 0;
        int wreaths = 0;
        while (lilies.peek() != null && roses.peek() != null) {
            int sum = lilies.pop() + roses.poll();

            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                wreaths++;
            } else {
                leftFlowers += sum;
            }
        }
        wreaths += leftFlowers /15;

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n",wreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
