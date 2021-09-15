package ExceptionAndErrorHandling.Lab;

import java.util.Scanner;

public class P02 {
    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Pair numbers = readInput(scanner);
                pintRange(numbers);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void pintRange(Pair numbers) {
        for (int i = numbers.first; i <= numbers.second ; i++) {
            System.out.println(i);

        }
    }

    private static Pair readInput(Scanner scanner) {
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        if (first < 1 || first > second || second > 100) {
            throw new IllegalArgumentException("Invalid input the input must be: 1 < start < end");
        }

        return new Pair(first, second);
    }
}
