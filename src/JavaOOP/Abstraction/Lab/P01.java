package JavaOOP.Abstraction.Lab;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int r = 1; r <= n; r++) {
            System.out.print(repeatString(n - r, " "));
            System.out.print(repeatString(r, "* "));
            System.out.println();
        }

        for (int r = 1; r <= n -1; r++) {
            System.out.print(repeatString(r, " "));
            System.out.print(repeatString(n - r, "* "));
            System.out.println();
        }
    }
    public static String repeatString(int count , String repet){
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < count; i++) {
            out.append(repet);
        }
        return out.toString();
    }


}
