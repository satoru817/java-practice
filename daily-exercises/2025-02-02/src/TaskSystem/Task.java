package TaskSystem;

import java.time.LocalDateTime;

public class Task {
    private final int id;
    private final String name;
    private final Priority priority;
    private TaskStatus taskStatus;
    private boolean isCompleted;
    private LocalDateTime startedAt = null;
    private LocalDateTime endedAt = null;

    public Task(int id, String name, Priority priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isCompleted = false;
        this.taskStatus = TaskStatus.WAITING;
    }

    public void starts(){
        if(taskStatus != TaskStatus.WAITING){
            throw new RuntimeException("task has already started");
        }
        taskStatus = TaskStatus.RUNNING;
        startedAt = LocalDateTime.now();
    }



    @Override
    public String toString(){
        return String.format(
                "TASK{ID: %s, NAME: %s, PRIORITY: %s, IS_COMPLETED: %s, TASK_STATUS: %s}",
                        id,
                        name,
                        priority,
                        isCompleted,
                        taskStatus
                );
    }

    public void complete(){
        if(taskStatus!= TaskStatus.RUNNING){
            throw new RuntimeException("task has not been running");
        }
        this.isCompleted = true;
        this.taskStatus = TaskStatus.COMPLETED;
        this.endedAt = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
