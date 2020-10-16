package bg.softuni.fundamentals.Data.Types;

import java.util.Scanner;

public class CharsToStrinLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char s1 = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(s1)){
            System.out.println("upper-case");
        }else {
            System.out.println("lower-case");
        }
    }
}
