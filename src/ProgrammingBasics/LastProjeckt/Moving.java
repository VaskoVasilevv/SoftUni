package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int withc = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());
        int hight = Integer.parseInt(scanner.nextLine());

        int totalSpace = withc * lenght * hight;

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            int boxses = Integer.parseInt(input);
            totalSpace -= boxses;


            if (totalSpace < 0) {
                break;
            }
            input = scanner.nextLine();

        }

        if (totalSpace < 0 ){
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalSpace));

        }else {
            System.out.printf("%d Cubic meters left.",totalSpace);
        }
    }
}
