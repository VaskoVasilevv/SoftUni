import java.util.Scanner;

public class Numbersequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int minNUm = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            int curentNum = Integer.parseInt(scanner.nextLine());

            if (curentNum > maxNum){
                maxNum = curentNum;
            }
            if (curentNum < minNUm){
                minNUm = curentNum;
            }
        }
        System.out.println("Max number: " + maxNum);
        System.out.println("Min number: " + minNUm);
    }
}
