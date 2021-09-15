package Methods;

import java.util.Scanner;

public class MultilyEvensByOddsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(getMultiplyOfEvensAndOdds(number));
    }

    static int getMultiplyOfEvensAndOdds(int n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);
        return evenSum * oddSum;
    }

    static int getEvenSum(int n) {
        int evensSum = 0;
        while (n != 0) {
            int lastNum = n % 10;
            if (lastNum % 2 == 0) {
                evensSum += lastNum;
            }
            n -= lastNum;
            n /= 10;
        }
        return evensSum;
    }

    static int getOddSum(int n) {
        int sumOfOdd = 0;
        while (n != 0) {
            int lastNum = n % 10;
            if (lastNum % 2 == 1) {
                sumOfOdd += lastNum;
            }
            n -= lastNum;
            n /= 10;
        }
        return sumOfOdd;
    }
}
