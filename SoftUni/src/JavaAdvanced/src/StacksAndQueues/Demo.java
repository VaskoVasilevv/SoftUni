package StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.push(24);
        Integer element = deque.peek();

        System.out.println(element);
        System.out.println(deque.isEmpty());


    }
}
