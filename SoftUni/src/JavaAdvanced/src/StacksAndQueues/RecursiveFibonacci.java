package StacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n+1));
    }
    private static int fibonacci(long n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return fibonacci(n -1) + fibonacci(n -2);
        }

    }
}
