package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parking = new LinkedHashSet<>();
        while (!input.equals("END")){
            String registration = input.substring(input.indexOf(", ") +2);

            if (input.contains("IN")){
                parking.add(registration);
            }else {
                parking.remove(registration);
            }

            input= scanner.nextLine();
        }
        String output;
        if (!parking.isEmpty()){
            output = parking.stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        }else {
            output = "Parking Lot is Empty";
        }
        System.out.println(output);
    }
}
