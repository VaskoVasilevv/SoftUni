package Fundamentals.Objects;

import java.util.*;

public class E04SongsLAB {
    static class Song {
        String typeList;
        String name;
        String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("_");
            Song song = new Song(data[0], data[1], data[2]);
            songs.add(song);

        }
        String input = scanner.nextLine();

        if (input.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }

        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(input)) {
                    System.out.println(song.getName());
                }
            }

        }
        //List<Song> filterSong = songs.stream().filter(e -> e.getTypeLit().equals(typeList))
        //                .collect(Collectors.toList());
        //   for (Song song : filterSong) {
        //            System.out.println(song.getName());
        //   }

    }
}
