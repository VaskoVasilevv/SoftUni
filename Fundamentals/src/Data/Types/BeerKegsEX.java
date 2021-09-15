package Data.Types;

import java.util.Scanner;

public class BeerKegsEX {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxVolume = Double.MIN_VALUE;
        String biggerKeg = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double  courrentVolume = Math.PI * radius * radius * height;

            if (courrentVolume > maxVolume){
                maxVolume = courrentVolume;
                biggerKeg = model;
            }


        }
        System.out.println(biggerKeg);
    }
}
