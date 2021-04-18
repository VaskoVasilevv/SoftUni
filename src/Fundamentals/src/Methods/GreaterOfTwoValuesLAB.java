package Methods;

import java.util.Scanner;

public class GreaterOfTwoValuesLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (input.equals("int")){
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            System.out.println(getMax(f,s));
        }else if (input.equals("char")){
            char f = scanner.nextLine().charAt(0);
            char s = scanner.nextLine().charAt(0);
            System.out.println(getMax(f,s));
        } else {
            String f =scanner.nextLine();
            String s =scanner.nextLine();
            System.out.println(getMax(f,s));
        }

    }
    public static char getMax(char first,char second){
        if (first > second){
            return first;
        }
        return second;
    }
    public static int getMax(int first,int second){
        if (first > second){
            return first;
        }
        return second;
    }
    public static String getMax(String first,String second){
        if (first.compareTo(second) >= 0){
            return first;
        }
        return second;
    }
    public static double getMax(double first,double second){
        if (first > second){
            return first;
        }
        return second;
    }
}
