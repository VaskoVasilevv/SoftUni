package Fundamentals.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LIVE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> names = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        //String line = scanner.nextLine();
        //        String[] numbersAsStrings = line.split(" ");
        //
        //        List<Integer> numbers = new ArrayList<>();
        //
        //        for (String s : numbersAsStrings) {
        //            int number = Integer.parseInt(s);
        //            numbers.add(number);
        //       4ETENE OT KONZOLATA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        int [] arr = new int[]{42,13,255};
        System.out.println(arr.length);
        System.out.println(arr[0]);
        arr[0] = 5;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("----------");

        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(42);
        list.add(13);
        list.add(255);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.set(0,5);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }


    }
}
