public class LibraryManager {
    public boolean lendBook(User user,Book book){
        if(user.getBooks().size() >= 3 || book.isLoaned()){
            return false;
        }
        user.borrowBook(book);
        book.setLoaned(true);
        return true;
    }

    public boolean returnBook(User user, Book book) {
        book.returnBook();
        return user.returnBook(book);
    }
}
