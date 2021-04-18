package JavaAdvanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();


        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stack.push(symbol);
            } else if (symbol == '}') {
                char first = stack.pop();

                if (first == '{') {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            } else if (symbol == ']') {
                char first = stack.pop();

                if (first == '[') {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            } else if (symbol == ')') {
                char first = stack.pop();

                if (first == '(') {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
