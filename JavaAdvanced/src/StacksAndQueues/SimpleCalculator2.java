package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int rightOperand = Integer.parseInt(tokens[++i]);
                int leftOperand = numbers.peek();
                numbers.push(rightOperand);

                int result = token.equals("+")
                        ? leftOperand + rightOperand
                        : leftOperand - rightOperand;
                numbers.push(result);
            }
            System.out.println(numbers.peek());
        }


//        Proverka za kolko pamet
//        int[] numbers = new int[32];
//        System.out.println(numbers.length * Integer.BYTES);


    }
}
