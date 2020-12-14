import java.util.Scanner;

public class CatShirt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int razmerNaRukava = Integer.parseInt(scanner.nextLine());
        int prednaChast = Integer.parseInt(scanner.nextLine());
        String materiq = scanner.nextLine();
        String vratovruzka = scanner.nextLine();

        double razmerRiza = razmerNaRukava * 2 + prednaChast * 2;
        razmerRiza += razmerRiza * 0.1;
        double size  = razmerRiza / 100;

        double price = 0;
        switch (materiq) {
            case "Linen":
                price = 15;
                break;
            case "Cotton":
                price = 12;
                break;
            case "Denim":
                price = 20;
                break;
            case "Twill":
                price = 16;
                break;
            case "Flannel":
                price = 11;
                break;
            default:
                break;
        }

        double end = (size * price) + 10;
        if (vratovruzka.equals("Yes")) {
            end += end * 0.2;
        }
        System.out.printf("The price of the shirt is: %.2flv.", end);

    }
}
