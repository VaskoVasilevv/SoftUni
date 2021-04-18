package Methods;

import java.util.Scanner;

public class CharactersInRangeEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        printFromFirstToSecondChar(first,second);
    }
    public static void printFromFirstToSecondChar (char a,char b){
        if (a < b){
            for (char i = (char) (a + 1); i <b ; i++) {
                System.out.print(i + " ");
            }
        }else {
            for (char i = (char) (b + 1); i <a ; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
