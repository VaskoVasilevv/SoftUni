package bg.softuni.fundamentals.Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbersEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println(getSmallestNum(getSmallestNum(first,second),third));
    }
    public static int getSmallestNum (int a,int b){
        if (a < b){
            return a;
        }
        return b;
    }
}
