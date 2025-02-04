import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {
    private final String isbn;
    private final String title;
    private List<String> authors;
    private boolean isAvailable;
    private LocalDate publishDate;

    private Book(builder b){
        this.isbn = b.isbn;
        this.title = b.title;
        this.isAvailable=b.isAvailable;
        this.authors=b.authors;
        this.publishDate=b.publishDate;
    }

    @Override
    public int compareTo(Book b) {
        int i = (int) ChronoUnit.DAYS.between(this.publishDate,b.publishDate);
        return i;
    }


    public static class builder{
        private final String isbn;
        private final String title;
        private List<String> authors;
        private boolean isAvailable;
        private LocalDate publishDate;

        public builder(String isbn,String title){
            this.isbn = isbn;
            this.title = title;
            this.isAvailable = true;
        }

        public builder authors(List<String> authors){
            this.authors = authors;
            return this;
        }

        public builder publishDate(LocalDate publishDate){
            this.publishDate = publishDate;
            return this;
        }

        public builder isAvailable(boolean isAvailable){
            this.isAvailable = isAvailable;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}