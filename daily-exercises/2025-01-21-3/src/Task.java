public class Task implements Comparable<Task> {
    private int id;
    private String title;
    private boolean completed;
    private int priority;  // 1: 低, 2: 中, 3: 高

    // コンストラクタ
    public Task(int id, String title, boolean completed, int priority) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.priority = priority;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task task) {
        return this.priority-task.priority;
    }
}