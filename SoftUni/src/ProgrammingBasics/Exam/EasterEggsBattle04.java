import java.util.Scanner;

public class EasterEggsBattle04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPlayer = Integer.parseInt(scanner.nextLine());
        int secondPlayer = Integer.parseInt(scanner.nextLine());

        String inpt = "";

        while (!inpt.equals("End of battle")) {
            inpt = scanner.nextLine();

            switch (inpt) {
                case "one":
                    secondPlayer -= 1;
                    break;
                case "two":
                    firstPlayer -= 1;
                    break;
            }
            if (firstPlayer == 0 || secondPlayer == 0) {

                break;
            }
        }
        if (firstPlayer == 0) {
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.%n", secondPlayer);
        }else if (secondPlayer == 0) {
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.%n", firstPlayer);
        }else {
            System.out.printf("Player one has %d eggs left.%n", firstPlayer);
            System.out.printf("Player two has %d eggs left.%n", secondPlayer);
        }

    }
}

