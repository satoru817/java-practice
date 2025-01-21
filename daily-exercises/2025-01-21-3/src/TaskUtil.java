import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskUtil {
    private final List<Task> tasks;

    public TaskUtil(){
        this.tasks = new ArrayList<>();
    }

    public TaskUtil(List<Task> tasks){
        this.tasks = tasks;
    }

//    設問1: 以下の要件を満たすメソッドを実装してください。
//
//    完了していないタスクを、優先度の高い順にソートする
//            タイトルが空文字またはnullのタスクは除外する
//    結果は新しいListとして返す

//    public List<Task> getSorted(){
//        return tasks.stream()
//                .filter(task -> {
//                    boolean b = task.getTitle() != null && !task.getTitle().isBlank();
//                    return b;
//                })
//                .sorted()
//                .collect(Collectors.toUnmodifiableList());
//    }

    //AIによる改善案
    public List<Task> getSortedTasks(){
        return tasks.stream()
                .filter(task->!task.isCompleted())
                .filter(task -> task.getTitle()!=null
                && !task.getTitle().isBlank())
                .sorted((t1,t2)->t2.getPriority()-t1.getPriority())//ここの順序を間違えがち
                .collect(Collectors.toUnmodifiableList());
    }
}
