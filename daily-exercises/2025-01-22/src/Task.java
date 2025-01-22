import java.time.LocalDate;

public class Task {
    private final int id;
    private String title;
    private boolean completed;
    private LocalDate createdAt;

    public Task(int id,String title) {
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("タイトルが不正です");
        }
        this.id = id;
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDate.now();
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void toggleStatus(){
        this.completed = !this.completed;
    }

    @Override
    public String toString(){
        return String.format(
                "Task{id: %s, title: %s, completed: %s, createdAt: %s}",
                id,
                title,
                completed,
                createdAt
        );
    }
}
