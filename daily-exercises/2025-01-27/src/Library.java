import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // 本の追加
    public void addBook(Book book){
        books.add(book);
    }

    // ISBNで本を検索（Optional使用）
    public Optional<Book> findByIsbn(String isbn){
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();

    }

    // 著者名で本を検索（Stream API使用）
    public List<Book> findByAuthor(String author){
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    // 特定の日付以降に出版された本のリストを取得
    public List<Book> findBooksPublishedAfter(LocalDate date){
        return books.stream()
                .filter(book -> book.getPublishDate().isAfter(date))
                .toList();
    }

    // 貸出可能な本のみを取得
    public List<Book> getAvailableBooks(){
        return books.stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
