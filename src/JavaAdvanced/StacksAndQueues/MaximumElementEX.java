package JavaAdvanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElementEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            switch (line[0]) {
                case 1:
                    int number = line[1];
                    numbersStack.push(number);
                    break;
                case 2:
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop();
                    }
                    break;
                case 3:
                    Integer maxNumber = Collections.max(numbersStack);
                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}
