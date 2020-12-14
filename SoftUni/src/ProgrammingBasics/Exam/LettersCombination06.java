import java.util.Scanner;

public class LettersCombination06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char c = scanner.nextLine().charAt(0);
        int counter = 0;

        for (char i = first; i <= second; i++) {
            if (i == c){
                continue;
            }
            for (int j = first; j <= second ; j++) {
                if (j == c){
                    continue;
                }
                for (int k = first; k <= second ; k++) {
                    if (k == c){
                        continue;
                    }
                    System.out.printf("%c%c%c ",i,j,k);
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
