package MidEXAM;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        int lastPosition = 0;
        while (!input.equals("Love!")) {
            String[] command = input.split(" ");
            if (command[0].equals("Jump")) {
                int length = Integer.parseInt(command[1]);
                lastPosition += length;

                if (lastPosition >= neighborhood.length) {
                    lastPosition = 0;
                }
                if (neighborhood[lastPosition] != 0) {
                    neighborhood[lastPosition] -= 2;
                    if (neighborhood[lastPosition] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", lastPosition);
                    }
                } else {
                    System.out.printf("Place %d already had Valentine's day.%n", lastPosition);
                }

            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", lastPosition);
        int failed = 0;
        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] > 0) {
                failed++;
            }
        }
        if (failed > 0) {
            System.out.printf("Cupid has failed %d places.%n", failed);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
