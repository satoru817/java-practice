import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskManager<T extends Task> implements ITaskManager<T>{
    private final List<T> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(T task) {
        tasks.add(task);
    }

    @Override
    public void completeTask(Integer taskId) {
        tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .ifPresent(task -> task.setCompleted(true));
    }

    @Override
    public void deleteTask(Integer taskId) {
        tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .ifPresent(tasks::remove);
    }

    @Override
    public List<T> getTasksSortedByPriority() {
        return tasks.stream()
                .sorted()
                .toList();
    }

    @Override
    public List<T> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .toList();
    }

    @Override
    public List<T> getIncompleteTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .toList();
    }

    @Override
    public Optional<T> findTaskById(Integer taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst();
    }
}
