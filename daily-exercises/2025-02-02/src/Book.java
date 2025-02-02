public class Book {
    private int id;
    private String title;
    private boolean isLoaned;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isLoaned = false;
    }

    public boolean lendBook(){
        if(!isLoaned){
            isLoaned = true;
            return true;
        }
        throw new RuntimeException("the book is already loaned");
    }

    public boolean returnBook(){
        if(!isLoaned){
            throw new RuntimeException("the book is already returned");
        }
        isLoaned = false;
        return true;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }
}
