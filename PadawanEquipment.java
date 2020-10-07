package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyHave = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = 0;
        int belt = students / 6;
        double students1 = Math.ceil((students * 0.1)+ students);




        totalPrice = (students1 * lightsabersPrice) + robesPrice * students + (students - belt) * beltsPrice;
        if (totalPrice <= moneyHave){
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else {
            System.out.printf("Ivan Cho will need %.2flv more.",totalPrice - moneyHave);
        }

    }
}
