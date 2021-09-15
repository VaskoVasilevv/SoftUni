package MidEXAM;

import java.util.Arrays;
import java.util.Scanner;

public class E02ShootForTheWin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int counter = 0;

        String input = scanner.nextLine();
        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if (index < array.length){
                int valueToReduce = array[index];
                array[index] = -1;
                counter++;
                for (int i = 0; i < array.length ; i++) {
                    if (array[i] != -1 && array[i] > valueToReduce){
                        array[i] -= valueToReduce;

                    }else if (array[i] != -1 && array[i] <= valueToReduce){
                        array[i] += valueToReduce;
                    }

                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",counter);
        for (int i : array) {
            System.out.printf("%d ",i);
        }


    }
}
