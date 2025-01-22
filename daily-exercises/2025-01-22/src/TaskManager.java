import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 課題：TaskManagerクラスの実装
 *
 * 要件：
 * 1. Taskのリストを管理するクラスを作成
 * 2. 以下の機能を実装：
 *    - タスクの追加
 *    - ID指定でのタスクの取得
 *    - 完了済みタスクのリスト取得
 *    - 未完了タスクのリスト取得
 *
 * 3. 追加要件：
 *    - タスク追加時にIDが重複している場合は例外をスロー
 *    - リストを返す際は不変のリストとして返す（Collections.unmodifiableList）
 *    - Stream APIを使用して実装する
 */

public class TaskManager {
    private final List<Task> tasks;

//    public TaskManager(List<Task> tasks) {
//        this.tasks = tasks;
//    }
    //状態管理をより確実に
    public TaskManager(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
//        List<Task> matched = tasks.stream()
//                .filter(task1->task1.getId()== task.getId() )
//                .toList();
//        if(!matched.isEmpty()){
//            throw new IllegalArgumentException("重複するIDのタスクがあります。");
//        }

        boolean isDuplicate = tasks.stream()
                        .anyMatch(existingTask ->existingTask.getId()== task.getId());

        if(isDuplicate){
            throw new IllegalArgumentException("重複するIDのタスクがあります");
        }

        tasks.add(task);
    }

    public Task getById(int id){
        Task matched = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(()->new RuntimeException("該当のIDのタスクはありません"));
        return  matched;
    }

    public List<Task> getIncompleteTasks(){
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Task> getCompleteTasks(){
        return tasks.stream()
                .filter(task -> task.isCompleted())
                .collect(Collectors.toUnmodifiableList());
    }
    // タスクの総数を取得するメソッドの追加
    public int getTaskCount() {
        return tasks.size();
    }

}
