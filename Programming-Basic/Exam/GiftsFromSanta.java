import java.util.Scanner;

public class GiftsFromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());

        if (n >= 0 && n < m) {
            if (m <= 1000) {
                if (s >= n && s <= m) {
                    for (int i = m; i >= n; i--) {
                        if (i % 2 == 0 && i % 3 == 0) {
                            if (s == i) {
                                break;
                            } else {
                                System.out.print(i + " ");
                            }
                        }
                    }
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
