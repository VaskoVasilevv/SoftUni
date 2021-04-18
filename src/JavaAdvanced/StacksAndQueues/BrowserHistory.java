package JavaAdvanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String navigations = scanner.nextLine();
        String current = "";
        while (!navigations.equals("Home")){
            if (navigations.equals("back")){
                if (history.isEmpty()){
                    System.out.println("no previous URLs");
                    navigations = scanner.nextLine();
                    continue;
                }else {
                    current = history.pop();
                }
            }else {
                if (!current.isEmpty()){
                    history.push(current);
                }
                current = navigations;
            }
            navigations = scanner.nextLine();
            System.out.println(current);
        }



    }
}
