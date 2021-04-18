package Fundamentals.Objects;

import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessageEX {
    static class Message {

        String[] phrase = {"Excellent product.", "Such a great product.", "I always use that product."
                , "Best product of its category.", "Exceptional product."
                , "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product."
                , "Makes miracles. I am happy of the results!"
                , "I cannot believe but now I feel awesome."
                , "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        public String randomMessage() {
            return String.format("%s %s %s – %s", phrase[random.nextInt(phrase.length)], events[random.nextInt(events.length)],
                    author[random.nextInt(author.length)], cities[random.nextInt(cities.length)]);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Message message = new Message();

        for (int i = 0; i < n; i++) {

            System.out.println(message.randomMessage());
        }

    }
}
