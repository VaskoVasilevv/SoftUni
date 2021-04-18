package JavaOOP.Encapsulation.Ex.AnimalFarm_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Chicken chicken = new Chicken("Koko",10);

        System.out.println(chicken.toString());
    }
}
