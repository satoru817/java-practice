import java.time.LocalDate;

public class Book {
    private final static String ISBN = "^\\d{13}";
    private final String isbn;
    private final String title;
    private final String author;
    private final LocalDate publishDate;
    private boolean isAvailable;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Book(String isbn, String title, String author, LocalDate publishDate) {
        if(!validateISBN(isbn)){
            throw new RuntimeException("isbnの値が不正です");
        }

        if(title.trim().isEmpty() || author.trim().isEmpty() ||publishDate == null){
            throw new RuntimeException("タイトル、著者名、出版日のいずれかに不備があります");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isAvailable = true;
    }

    public boolean validateISBN(String isbn){
        return isbn.matches(ISBN);
    }

    @Override
    public String toString(){
        return String.format(
                "BOOK{isbn: %s, title: %s, author: %s, publishDate: %s, isAvailable: %s}",
                isbn,
                title,
                author,
                publishDate,
                isAvailable
        );
    }


}

