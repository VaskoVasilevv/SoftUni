package LastProjeckt;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int oddSsum  = 0 ;
        int evenSsum  = 0 ;
        for (int i = 1; i <= n ; i++) {
            int curentNums = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0 ){
                evenSsum = evenSsum + curentNums;
            }else {
                oddSsum = oddSsum + curentNums;
            }
        }
        if (evenSsum == oddSsum ){
            System.out.printf("Yes%nSum = %d",evenSsum);
        }else  {
            System.out.printf("No%nDiff = %d",Math.abs(evenSsum - oddSsum));
        }
    }
}
