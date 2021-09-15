package Objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E04Articles2EX {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Article> dataList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article data = new Article(input[0], input[1], input[2]);
            dataList.add(data);
        }
        String input = scanner.nextLine();
        switch (input) {
            case "title":
                dataList.stream().sorted(Comparator.comparing(Article::getTitle))
                        .forEach(data -> System.out.println(data.output()));
                break;
            case "content":
                dataList.stream().sorted(Comparator.comparing(Article::getContent))
                        .forEach(data -> System.out.println(data.output()));
                break;
            case "author":
                dataList.stream().sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(data -> System.out.println(data.output()));
                break;
        }
    }

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public String output() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
}
