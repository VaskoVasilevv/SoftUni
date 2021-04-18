package JavaAdvanced.Exam.Exam.dealership;

import java.util.*;
import java.util.stream.Collectors;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Queue
        ArrayDeque<Integer> first = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(second::push);

        List<Integer> data = new ArrayList<>();
        while (!first.isEmpty() && !second.isEmpty()){
            int currentFirst = first.poll();
            int currentSecond = second.pop();
            int sum = currentFirst + currentSecond;

            if (sum %2 == 0){
                data.add(sum);
            }else {
                first.offerFirst(currentFirst);
                first.offer(currentSecond);
            }
        }
        if (first.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (second.isEmpty()){
            System.out.println("Second magic box is empty.");
        }
        int sum2 = 0;
        for (Integer i : data) {
            sum2 += i;
        }
        if (sum2 >= 90){
            System.out.println("Wow, your prey was epic! Value: " + sum2);
        }else {
            System.out.println("Poor prey... Value: " + sum2);
        }


    }
}
