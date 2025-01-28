import java.time.LocalDateTime;

public class TaskWithBuilder {
    private final int id;
    private String title;
    private boolean completed;
    private final LocalDateTime createdAt;

    private TaskWithBuilder(Builder builder){
        checkTitle(builder.title);
        this.id = builder.id;
        this.title = builder.title;
        this.completed = builder.completed;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private final int id;
        private final String title;
        private boolean completed = false;
        private LocalDateTime createdAt = LocalDateTime.now();

        public Builder(int id, String title){
            checkTitle(title);
            this.id = id;
            this.title = title;
        }

        public Builder completed(boolean completed){
            this.completed = completed;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public TaskWithBuilder build(){
            return new TaskWithBuilder(this);
        }


    }


    public static void checkTitle(String title){
        if(title == null ||title.trim().isEmpty()){
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
