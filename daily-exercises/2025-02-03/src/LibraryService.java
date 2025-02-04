import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryService {
    private final List<LibraryMember> libraryMembers;

    public LibraryService(){
        this.libraryMembers = new ArrayList<>();
    }

    public List<Book> getLoanedBooks(){
        return libraryMembers.stream()
                .map(LibraryMember::getBorrowedBooks)
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Book> getAuthorsBook(String author){
        return libraryMembers.stream()
                .map(LibraryMember::getBorrowedBooks)
                .flatMap(List::stream)
                .filter(book -> book.getAuthors().stream().anyMatch(str->str.toUpperCase().contains(author.toUpperCase())))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LibraryMember> getExpiredMember(){
        return libraryMembers.stream()
                .filter(member->member.getMembershipStartDate().isBefore(LocalDate.now().minusYears(1)))
                .collect(Collectors.toUnmodifiableList());
    }





}
