package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kid = new ArrayDeque<>();

        for (String s : input) {
            kid.offer(s);
        }

        while (kid.size() > 1) {
            for (int i = 1; i < n; i++) {
                kid.offer(kid.poll());
            }
            System.out.println("Removed " + kid.poll());
        }
        System.out.println("Last is " + kid.poll());
    }
}
