package MidEXAM;

import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split("\\|");
        int[] targetNumbers = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            targetNumbers[i] = Integer.parseInt(inputs[i]);
        }

        int sumPoints = 0;
        String input = scanner.nextLine();
        while (!input.equals("Game over")) {
            String[] tokens = input.split("@");
            String command = tokens[0];

            switch (command) {
                case "Shoot Left":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int leftLength = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < targetNumbers.length){
                        int targetIndexLeft = startIndex - leftLength;
                        while (targetIndexLeft < 0){
                            targetIndexLeft = targetNumbers.length + targetIndexLeft;
                        }
                        if (targetNumbers[targetIndexLeft] >= 5){
                            targetNumbers[targetIndexLeft] -= 5;
                            sumPoints += 5;
                        }else {
                            sumPoints += targetNumbers[targetIndexLeft];
                            targetNumbers[targetIndexLeft]=0;
                        }
                    }
                    break;
                case "Shoot Right":
                    int startIndexRight = Integer.parseInt(tokens[1]);
                    int rightLength = Integer.parseInt(tokens[2]);
                    if (startIndexRight >= 0 && startIndexRight < targetNumbers.length){
                        int targetIndex = startIndexRight + rightLength;
                        while (targetIndex >= targetNumbers.length){
                            targetIndex = targetIndex - targetNumbers.length;
                        }
                        if (targetNumbers[targetIndex]>= 5){
                            targetNumbers[targetIndex] -= 5;
                            sumPoints+= 5;
                            
                        }else {
                            sumPoints += targetNumbers[targetIndex];
                            targetNumbers[targetIndex] = 0;
                        }
                    }
                    
                    break;
                case "Reverse":
                    for (int i = 0; i < targetNumbers.length / 2 ; i++) {
                        int current = targetNumbers[i];
                        targetNumbers[i] = targetNumbers[targetNumbers.length -1 - i];
                        targetNumbers[targetNumbers.length -1 - i] = current;
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < targetNumbers.length -1; i++) {
            System.out.print(targetNumbers[i] + " - ");
        }
        System.out.println(targetNumbers[targetNumbers.length-1]);
        System.out.printf("Iskren finished the archery tournament with %d points!",sumPoints);
    }
}
