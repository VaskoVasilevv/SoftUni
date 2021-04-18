package Fundamentals.Objects;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Live {
    static class Reservation {
        String holderName;
        String phoneNumber;
        int seats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Reservation> reservations = new ArrayList<>();


        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] nameAndSeats = input.split(" ");
            String holder = nameAndSeats[0];
            String phone = nameAndSeats[1];
            int seat = Integer.parseInt(nameAndSeats[2]);
            Reservation r = new Reservation();
            r.holderName = holder;
            r.seats= seat;
            r.phoneNumber = phone;
            reservations.add(r);

            input = scanner.nextLine();
        }
        String guestName = scanner.nextLine();
        int reservationIndex = -1;
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (guestName.equals(reservation.holderName)){
                reservationIndex = i;
            }

        }

        if (reservationIndex != -1) {
            Reservation reservation = reservations.get(reservationIndex);
            System.out.println(reservation.seats);
        } else {
            System.out.println("Sorry no reservation for " + guestName);
        }
    }
}
