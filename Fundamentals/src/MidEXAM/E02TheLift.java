package MidEXAM;

import java.util.Arrays;
import java.util.Scanner;

public class E02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int [] currentState = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < currentState.length; i++) {
            if (currentState[i] <= 4){
                if (people >= 4 - currentState[i] ){
                    people -= 4 - currentState[i];
                    currentState[i] = 4;

                }else {
                    currentState[i]+= people;
                    people -= currentState[i];
                }
            }
        }
        boolean full = true;
        for (int peopleInLift : currentState) {
            if (peopleInLift != 4) {
                full = false;
                break;
            }
        }


        if (people==0 && !full){
            System.out.println("The lift has empty spots!");

        }else if (people > 0 && full){
            System.out.printf("There isn't enough space! %d people in a queue!%n",people);
        }
        System.out.println(Arrays.toString(currentState).replaceAll("[\\[\\],]",""));
    }
}
