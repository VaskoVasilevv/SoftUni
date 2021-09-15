package ExceptionAndErrorHandling.Lab;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(Math.sqrt(Double.parseDouble(scanner.nextLine())));
        }catch (NumberFormatException ignored){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }


    }

    public static int increase(int number){
        printNumber(number);
        return number +10;
    }

    private static void printNumber(int number) {
        System.out.println(number);
    }
}
