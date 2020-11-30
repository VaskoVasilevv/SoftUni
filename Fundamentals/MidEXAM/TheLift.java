package bg.softuni.fundamentals.MidEXAM;

import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] initialStateWagon = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            initialStateWagon[i] = Integer.parseInt(input[i]);
        }
        int peopleOnTheCurrentWagon = 0;
        int peopleOnTheLift = 0;
        boolean noMorePeople = false;

        for (int i = 0; i < initialStateWagon.length; i++) {
            while (initialStateWagon[i] < 4) {
                initialStateWagon[i]++;
                peopleOnTheCurrentWagon++;
                if (peopleOnTheCurrentWagon + peopleOnTheLift == peopleWaiting) {
                    noMorePeople = true;
                    break;
                }

            }
            peopleOnTheLift += peopleOnTheCurrentWagon;
            if (noMorePeople) {
                break;
            }
            peopleOnTheCurrentWagon = 0;

        }
        boolean full = true;
        for (int value : initialStateWagon) {
            if (value != 4) {
                full = false;
                break;
            }
        }
        if (noMorePeople && !full) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 0 && full) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting - peopleOnTheLift);
        }
        printWagons(initialStateWagon);
    }

    private static void printWagons(int[] initialStateWagon) {
        for (int i = 0; i < initialStateWagon.length; i++) {
            if (i == 0) {
                System.out.print(initialStateWagon[i]);
            } else {
                System.out.print(" " + initialStateWagon[i]);
            }
        }
    }
}
