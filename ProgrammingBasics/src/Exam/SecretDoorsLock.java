package Exam;

import java.util.Scanner;

public class SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stotici = Integer.parseInt(scanner.nextLine());
        int desetici = Integer.parseInt(scanner.nextLine());
        int edinici = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= stotici; i ++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= desetici; j++) {
                    if (j == 2 || j == 3 || j == 5 || j == 7) {
                        for (int k = 1; k <= edinici; k ++) {
                            if (k % 2 == 0) {
                                System.out.printf("%d %d %d%n", i, j, k);
                            }
                        }
                    }
                }
            }
        }

    }
}
