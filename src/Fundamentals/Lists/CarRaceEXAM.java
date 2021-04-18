package Fundamentals.Lists;

import java.util.Scanner;

public class CarRaceEXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] raceTime = intArray(scanner);

        double leftCarTime = 0;
        double rightCarTime = 0;

        if (raceTime.length % 2 !=0){
            for (int i = 0; i < raceTime.length/2; i++) {
                leftCarTime += raceTime[i];
                if (raceTime[i]==0){
                    leftCarTime = leftCarTime * 0.8;
                }
            }
            for (int i = raceTime.length-1; i > raceTime.length/2 ; i--) {
                rightCarTime += raceTime[i];
                if (raceTime[i]==0){
                    rightCarTime = rightCarTime * 0.8;
                }
            }
        }
        if (leftCarTime<rightCarTime){
            System.out.printf("The winner is left with total time: %.1f",leftCarTime);
        }else {
            System.out.printf("The winner is right with total time: %.1f",rightCarTime);

        }

    }

    private static int[] intArray(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int [] time = new int[input.length];

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        return time;
    }
}
