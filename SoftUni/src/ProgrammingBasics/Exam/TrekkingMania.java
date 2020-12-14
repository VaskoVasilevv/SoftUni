import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gruoPeople = Integer.parseInt(scanner.nextLine());

        double musala = 0;
        double monblan = 0;
        double kilimandjaro = 0;
        double k2 = 0;
        double everest = 0;
        double totalPeople = 0;

        for (int i = 1; i <= gruoPeople ; i++) {
            int peopleNum = Integer.parseInt(scanner.nextLine());
            totalPeople += peopleNum;
            if (peopleNum <= 5){
                musala += peopleNum;
            }else if (peopleNum <= 12){
                monblan += peopleNum;
            }else if (peopleNum <= 25){
                kilimandjaro += peopleNum;
            }else if (peopleNum <= 40){
                k2 += peopleNum;
            }else if (peopleNum >= 41){
                everest += peopleNum;
            }

        }
        System.out.printf("%.2f%%%n",musala / totalPeople * 100);
        System.out.printf("%.2f%%%n",monblan / totalPeople * 100);
        System.out.printf("%.2f%%%n",kilimandjaro / totalPeople * 100);
        System.out.printf("%.2f%%%n",k2 / totalPeople * 100);
        System.out.printf("%.2f%%%n",everest / totalPeople * 100);
    }
}
