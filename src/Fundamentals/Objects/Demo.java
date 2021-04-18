package Fundamentals.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> reservationHolders = new ArrayList<>();
        List<Integer> reservationSeats = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] nameAndSeats = input.split(" ");
            reservationHolders.add(nameAndSeats[0]);
            reservationSeats.add(Integer.parseInt(nameAndSeats[1]));

            input = scanner.nextLine();
        }
        String guestName = scanner.nextLine();
        int reservationIndex  = reservationHolders.indexOf(guestName);

        if (reservationIndex != -1){
            System.out.println(reservationSeats.get(reservationIndex));
        }else {
            System.out.println("Sorry no reservation for "+ guestName);
        }
    }
}
