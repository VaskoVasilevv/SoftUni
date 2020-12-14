import java.util.Scanner;

public class CarNumber06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        for (int n1 = firstDigit; n1 <= secondDigit; n1++) {
            for (int n2 = firstDigit; n2 <= secondDigit; n2++) {
                for (int n3 = firstDigit; n3 <= secondDigit; n3++) {
                    for (int n4 = firstDigit; n4 < n1; n4++) {
                        if (n1 > n4) {
                            if (n1 % 2 == 0) {
                                if (n4 % 2 != 0) {
                                    if ((n1 - n4) % 2 != 0 && (n2 + n3) % 2 == 0) {
                                        System.out.printf("%d%d%d%d ",n1,n2,n3,n4);
                                    }
                                }
                            } else {
                                if (n4 % 2 == 0) {
                                    if (n1 % 2 != 0) {
                                        if ((n1 - n4) % 2 != 0 && (n2 + n3) % 2 == 0) {
                                            System.out.printf("%d%d%d%d ",n1,n2,n3,n4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

