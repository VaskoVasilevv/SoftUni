package Methods;

import java.util.Scanner;

public class шаблони {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        // int[] firstArray = readArray(scanner);
        // int[] secondArray = readArray(scanner);
        // printArray(secondArray);
        // printArray(firstArray);


    }


    static int[] readArray(Scanner scanner) {

        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");

        int[] array = new int[numbersAsStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        return array;
    }

    static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");

        }
        System.out.println();

    }

    static String repeat(String s, int count) {
        String[] repetitons = new String[count];
        for (int i = 0; i < count; i++) {
            repetitons[i] = s;
        }
        String repeated = String.join(" ", repetitons);
        return repeated;
    }

    static void printSum(int... numbers) {

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];

        }
        System.out.println(sum);

    }

    static int getSum(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    static void printLine(int length, char symbol) {
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);

        }
        System.out.println();
    }

    public static double mathPower(double number, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }

    public static double getArea(double width, double height) {
        return width * height;
    }

    public static char getMaxChar(char first, char second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    public static int getMaxInt(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    public static String getMaxString(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }

    static int getMultiplyOfEvensAndOdds(int n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);
        return evenSum * oddSum;
    }

    static int getEvenSum(int n) {
        int evensSum = 0;
        while (n != 0) {
            int nextNum = n % 10;
            if (nextNum % 2 == 0) {
                evensSum += nextNum;
            }
            n -= nextNum;
            n /= 10;
        }
        return evensSum;
    }

    static int getOddSum(int n) {
        int sumOfOdd = 0;
        while (n != 0) {
            int nextNum = n % 10;
            if (nextNum % 2 == 1) {
                sumOfOdd += nextNum;
            }
            n -= nextNum;
            n /= 10;
        }
        return sumOfOdd;
    }

    public static double calculate(int a, String operator, int b) {
        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = (double) a / b;
                break;
            case "*":
                result = a * b;
                break;
        }
        return result;
    }

    private static int getVowels(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = Character.toLowerCase(input.charAt(i));

            if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i') {
                counter++;
            }
        }
        return counter;
    }

    private static void printCharactersInRange(char first, char second) {
        if (first < second) {
            for (int i = first + 1; i < second; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                System.out.print((char) i + " ");
            }
        }

    }
    public static long calculateFactorial(int n){
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;

        }
        return factorial;
    }
    public static String palindromeIntegers(String number) {
        String output = "";
        String reversed = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            reversed += number.charAt(i);
        }
        if (reversed.equals(number)) {
            output = "true";
        } else {
            output = "false";
        }
        return output;

    }
    public static void arrayRotation(String[]input,int rotations){
        for (int i = 0; i < rotations; i++) {
            String rotatedNum = input[0];
            for (int j = 0; j < input.length-1; j++) {
                input [j] = input [j + 1];

            }
            input[input.length-1] = rotatedNum;
        }
        System.out.println(String.join(" ",input));
    }


}
