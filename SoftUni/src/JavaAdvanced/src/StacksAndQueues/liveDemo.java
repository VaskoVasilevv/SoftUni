package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;

public class liveDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String current = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    current = stack.pop();
                }
            } else {
                if (!current.isEmpty()) {
                    stack.push(current);
                }
                current = input;
            }

            input = scanner.nextLine();
            System.out.println(current);
        }

//        Proverka za kolko pamet
//        int[] numbers = new int[32];
//        System.out.println(numbers.length * Integer.BYTES);


    }
}
