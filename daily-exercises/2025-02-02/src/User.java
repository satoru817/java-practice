import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Book> books;

    public void borrowBook(Book book){
        books.add(book);
    }

    public boolean returnBook(Book book){
        return books.remove(book);
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
