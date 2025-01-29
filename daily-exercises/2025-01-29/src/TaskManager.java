import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if(!hasDuplicate(task)){
            tasks.add(task);
        }
    }

    public boolean hasDuplicate(Task task){
        return tasks.stream().anyMatch(task1 -> task1.hasSameId(task));
    }

    public List<Task> getCompletedTasks(){
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toUnmodifiableList());
    }

    public void toggleTaskStatus(int id){
        tasks.stream()
                .filter(task -> task.getId()==id)
                .forEach(task -> task.toggleStatus());
    }


}
