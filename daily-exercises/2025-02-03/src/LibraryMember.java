import java.time.LocalDate;
import java.util.List;

public class LibraryMember {
    private final String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private LocalDate membershipStartDate;

    public LibraryMember(builder b){
        this.memberId = b.memberId;
        this.name = b.name;
        this.borrowedBooks = b.borrowedBooks;
        this.membershipStartDate = b.membershipStartDate;
    }

    private class builder{
        private final String memberId;
        private String name;
        private List<Book> borrowedBooks;
        private LocalDate membershipStartDate;

        public builder(String memberId){
            this.memberId = memberId;
        }

        public builder name(String name){
            this.name = name;
            return this;
        }

        public builder borrowedBooks(List<Book> borrowedBooks){
            this.borrowedBooks = borrowedBooks;
            return this;
        }

        public builder membershipStartDate(LocalDate membershipStartDate){
            this.membershipStartDate = membershipStartDate;
            return this;
        }

        public LibraryMember build(){
            return new LibraryMember(this);
        }
    }
    // コンストラクタとgetterは実装済みとします

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }
}
