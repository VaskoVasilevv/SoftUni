package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class LeftOrRightSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int Leftsum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            Leftsum = Leftsum + num;

        }
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            rightSum = rightSum + num;
        }
        if (Leftsum == rightSum){
            System.out.printf("Yes, sum = %d", rightSum);
        }else {
            int diff = Math.abs(Leftsum - rightSum);
            System.out.printf("No, diff = %d", diff);
        }
    }
}
