import java.util.List;
import java.util.Optional;

public interface ITaskManager<T extends Task> {
    void addTask(T task);
    void completeTask(Integer taskId);
    void deleteTask(Integer taskId);
    List<T> getTasksSortedByPriority();
    List<T> getCompletedTasks();
    List<T> getIncompleteTasks();
    Optional<T> findTaskById(Integer taskId);
}