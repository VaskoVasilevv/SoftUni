package MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Inventory_индекси {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> itemsList= Arrays.stream((scan.nextLine().split(",+"))).collect(Collectors.toList());
        String input;
        IntStream.range(0, itemsList.size()).forEach(i -> itemsList.set(i, itemsList.get(i).trim()));
        while (!"Craft!".equals(input=scan.nextLine())){
            String[] command=input.split(" - ");
            switch (command[0]) {
                case"Collect":
                    if(!itemsList.contains(command[1])) {
                        itemsList.add(command[1]);
                    }
                    break;
                case"Drop": itemsList.remove(command[1]);
                    break;
                case"Combine Items":
                    String [] oldNewItem=command[1].split(":");
                    if(itemsList.contains(oldNewItem[0])){
                        itemsList.add(((itemsList.indexOf(oldNewItem[0]))+1),oldNewItem[1]);
                    }
                    break;
                case"Renew":
                    if(itemsList.contains(command[1])){
                        itemsList.add(itemsList.get(itemsList.indexOf(command[1])));
                        itemsList.remove(command[1]);
                    }
                    break;
            }
        }
        System.out.println(itemsList.toString().replaceAll("[\\[\\]]", ""));
    }
}
