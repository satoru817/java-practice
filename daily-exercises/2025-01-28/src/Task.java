import java.time.LocalDateTime;

public class Task {
    private final int id;
    private String title;
    private boolean completed;
    private final LocalDateTime createdAt;

    public Task(int id,String title){
        checkTitle(title);
        
        this.id=id;
        this.title = title.trim();
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public void checkTitle(String title){
        if(title == null ||title.isEmpty()){
            throw new IllegalArgumentException("有効なタイトルを設定してください");
        }
    }

    public void setTitle(String title){
        checkTitle(title);

        this.title = title.trim();
    }

    public void toggleStatus(){
        completed = !completed;
    }

    @Override
    public String toString(){
        return String.format(
                "Task{id: %s, title %s, completed: %s, createdAt: %s}",
                id,
                title,
                completed,
                createdAt
        );
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
