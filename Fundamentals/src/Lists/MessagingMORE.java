package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MessagingMORE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scan.nextLine();
        StringBuilder output = new StringBuilder();
        List<Character> textList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            textList.add(text.charAt(i));
        }
        for (int num : numbersList) {
            int index = 0;
            while (num > 0) {
                index += num % 10;
                num /= 10;
            }
            if (!(index < textList.size() - 1)) {
                index = (index % textList.size());
            }
            output.append(textList.get(index));
            textList.remove(index);
        }
        System.out.println(output);
    }
}
