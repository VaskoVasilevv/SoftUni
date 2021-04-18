package JavaAdvanced.Generics.Ex.GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Integer>> boxes = new ArrayList<>();

        while (n-- > 0) {
            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));
            boxes.add(box);
        }

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        swapBoxes(boxes, first, second);

        boxes.forEach(System.out::println);

    }

    public static <T extends Number> void swapBoxes(List<Box<T>> container, int first, int second) {
        Collections.swap(container, first, second);
//        Box<T> temp = container.get(first);
//        container.set(first,container.get(second));
//        container.set(second,temp);
    }
}
