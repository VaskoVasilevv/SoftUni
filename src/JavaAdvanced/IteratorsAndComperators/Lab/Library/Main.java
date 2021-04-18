package JavaAdvanced.IteratorsAndComperators.Lab.Library;

public class Main {
    public static void main(String[] args) {


        Book book1 = new Book("Book1",12);
        Book book2 = new Book("Book2",13,"Author");
        Book book3 = new Book("Book3",1555,"Pesho","Gosho");

        Library<Book> library = new Library<>();
        Library<Book> library2 = new Library<>(book1);
        Library<Book> library3 = new Library<>(book1,book2,book3);


        for (Book book : library2) {
            System.out.println(book.getTitle());
        }

    }
}
