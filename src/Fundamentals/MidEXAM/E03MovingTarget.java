package Fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            int value = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Shoot":
                    if (index >= 0 && index < numbers.size()){
                        if (numbers.get(index) > 0){
                            int i = numbers.get(index) - value;
                            numbers.set(index,i);
                        }
                        if (numbers.get(index) <= 0){
                            numbers.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index <numbers.size()){
                        numbers.add(index,value);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index >= 0 && index < numbers.size()){

                        int targetIndexLeft = index - value;
                        int targetIndexRight = index + value;
                        if (targetIndexLeft >= 0 && targetIndexRight <= numbers.size()){
                            for (int i = targetIndexLeft; i <= targetIndexRight ; i++) {
                                numbers.remove(targetIndexLeft);
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        // Принтира само числа разделени по ШПАЦИА
        // System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));

         //System.out.print(Arrays.toString(new List[]{numbers}).replaceAll("[\\[\\]]", "").replaceAll(", ", "|"));

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print("|");
            }

        }
    }
}
