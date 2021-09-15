package StacksAndQueues;

import java.util.*;


public class ReverseNumbersWithAStackEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int number : numbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }
}
