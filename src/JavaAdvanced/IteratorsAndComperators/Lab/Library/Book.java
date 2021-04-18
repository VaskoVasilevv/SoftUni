package JavaAdvanced.IteratorsAndComperators.Lab.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }

    private void setAuthors(String... authors){
        if (authors.length == 0){
            this.authors = new ArrayList<>();
        }else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }
}
