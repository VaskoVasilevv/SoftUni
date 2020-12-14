import java.util.Scanner;

public class PcGameShop05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int game1 = 0;
        int game2 = 0;
        int game3 = 0;
        int game4 = 0;

        for (int i = 1; i <= n; i++) {
            String game = scanner.nextLine();

            switch (game) {
                case "Hearthstone":
                    game1++;
                    break;
                case "Fornite":
                    game2++;
                    break;
                case "Overwatch":
                    game3++;
                    break;
                default:
                    game4++;
                    break;
            }

        }
        double total = game1 + game2 + game3 + game4;
        System.out.printf("Hearthstone - %.2f%%%n", game1 * 1.0 / total * 100);
        System.out.printf("Fornite - %.2f%%%n", game2 * 1.0 / total * 100);
        System.out.printf("Overwatch - %.2f%%%n", game3 * 1.0 / total * 100);
        System.out.printf("Others - %.2f%%%n", game4 * 1.0 / total * 100);
    }
}
