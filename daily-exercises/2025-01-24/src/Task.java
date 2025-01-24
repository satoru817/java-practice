import java.time.LocalDateTime;

public class Task implements Comparable<Task>{
    private final Integer id;
    private String title;
    private Priority priority;
    private boolean completed;
    private final LocalDateTime createdAt;

    public Task(Integer id, Priority priority, String title) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public int compareTo(Task task) {
        return  task.getPriority().getPriorityNum()-priority.getPriorityNum();
    }

    public Integer getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



}
