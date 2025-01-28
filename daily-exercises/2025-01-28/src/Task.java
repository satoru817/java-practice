import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task implements Comparable<Task>{
    private final int id;
    private String title;
    private boolean completed;
    private final LocalDateTime createdAt;
    private Priority priority;
    private LocalDate dueDate;


    private Task(Builder builder){
        checkTitle(builder.title);
        this.id = builder.id;
        this.title = builder.title;
        this.priority = builder.priority;
        this.completed = builder.completed;
        this.createdAt = builder.createdAt;
        this.dueDate = builder.dueDate;
    }

    public boolean isOverdue(){
        checkDueDate();
        return LocalDate.now().isAfter(dueDate);
    }

    public long getDaysUntilDue(){
        checkDueDate();
        return ChronoUnit.DAYS.between(LocalDate.now(),dueDate);
    }

    public void checkDueDate(){
        if(dueDate == null){
            String s = String.format(
                    "ID: %s,TITLE: %sの課題には期限が設定されていません",
                    id,
                    title
            );
            throw new RuntimeException(s);
        }
    }

    @Override
    public int compareTo(Task task) {
        if(this.priority==task.priority){
            if(this.dueDate.equals(task.dueDate)){
                return task.id-this.id;
            }else{
                return (int)ChronoUnit.DAYS.between(task.dueDate,dueDate);
            }
        };

        return task.priority.getValue()-this.priority.getValue();
    }

    public static class Builder {
        private final int id;
        private final String title;
        private boolean completed = false;
        private LocalDateTime createdAt = LocalDateTime.now();
        private Priority priority = Priority.MEDIUM;
        private LocalDate dueDate = null;

        public Builder(int id, String title){
            checkTitle(title);
            this.id = id;
            this.title = title;
        }

        public Builder dueDate(LocalDate dueDate){
            this.dueDate = dueDate;
            return this;
        }

        public Builder completed(boolean completed){
            this.completed = completed;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Builder priority(Priority priority){
            this.priority = priority;
            return this;
        }
        public Task build(){
            return new Task(this);
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
