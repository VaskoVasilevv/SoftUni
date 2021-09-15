package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LIstOfProductsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            names.add(name);
            Collections.sort(names);

        }
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(i + 1 +"."+name);

        }

    }
}
