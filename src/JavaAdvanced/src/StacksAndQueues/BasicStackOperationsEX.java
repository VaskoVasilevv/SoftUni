package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;
import java.util.function.IntFunction;

public class BasicStackOperationsEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            stack.push(number);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }


        int smallest = Integer.MAX_VALUE;
        boolean flag = false;

        for (Integer element : stack) {
            if (element < smallest) {
                smallest = element;
            }
            if (element == x) {
                flag = true;
                continue;
            }
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println(smallest);
            }
        }
    }
}
