package bg.softuni.fundamentals.Data.Types;

import java.util.Scanner;

public class ElevatorEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//int courses = Math.ceil((double) people/capacity);


        int numOfpeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int curses = numOfpeople / capacity;
        if (capacity >= numOfpeople) {
            curses += 1;
        } else if (numOfpeople % capacity != 0) {
            curses += 1;
        }
        System.out.println(curses);
    }
}
