import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
//    private List<Task> tasks;
//
//    public TaskManager(){
//        tasks = new ArrayList<>();
//    }
//
//    public void addTask(Task t){
//        tasks.add(t);
//    }
//
//    public List<Task> getTasksByPriority(){
//        return tasks.stream()
//                .sorted(Task::compareTo)
//                .toList();
//    }
//
//    public List<Task> getIncompleteTask(){
//        return tasks.stream()
//                .filter(task -> !task.completed)
//                .sorted(Task::compareTo)
//                .toList();
//    }
//
//    public boolean markAsCompleted(Integer id){
//        List<Task> match = tasks.stream()
//                .filter(task -> task.id == id)
//                .toList();
//        if(match.isEmpty()){
//            return false;
//        }
//
//        for(Task t : match){
//            t.completed = true;
//        }
//
//        return true;
//    }

    //AIによる改善提案
    private final List<Task> tasks;//初期化後に新しいリストを参照できないようにするためにfinalがついている

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if(task == null){
            throw new IllegalArgumentException("Task cannot be null");
        }

        tasks.add(task);
    }

    public List<Task> getTasksByPriority(){
        List<Task> collect = tasks.stream()
                .sorted()//Task::compareToは不要
                .collect(Collectors.toUnmodifiableList());//不変リストを返すようにする
        return collect;
    }

    public List<Task> getIncompleteTasks(){
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean markAsCompleted(Integer id){
        return tasks.stream()
                .filter(task -> task.getId().equals(id))//**重要なミス：WrapperクラスIntegerの比較のため、== ではなく.equals()を使うべき**
                .findFirst()
                .map(task -> {
                    task.setCompleted(true);
                    return true;
                })
                .orElse(false);
    }




}
