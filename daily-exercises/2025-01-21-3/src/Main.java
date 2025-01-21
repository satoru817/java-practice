import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // テスト用のタスクリストを作成
        List<Task> tasks = new ArrayList<>();

        // 様々なパターンのタスクを追加
        tasks.add(new Task(1, "高優先度の未完了タスク", false, 3));
        tasks.add(new Task(2, "中優先度の未完了タスク", false, 2));
        tasks.add(new Task(3, "低優先度の未完了タスク", false, 1));
        tasks.add(new Task(4, "高優先度の完了タスク", true, 3));
        tasks.add(new Task(5, null, false, 3));  // nullタイトル
        tasks.add(new Task(6, "", false, 3));    // 空文字タイトル
        tasks.add(new Task(7, "  ", false, 3));  // 空白のみのタイトル

        // TaskManagerクラスのインスタンスを作成
        TaskUtil manager = new TaskUtil(tasks);

        // ソート結果を取得
        List<Task> sortedTasks = manager.getSortedTasks();

        // 結果の表示
        System.out.println("=== ソート後のタスク一覧 ===");
        sortedTasks.forEach(task ->
                System.out.printf("ID: %d, Title: %s, Priority: %d, Completed: %b%n",
                        task.getId(),
                        task.getTitle(),
                        task.getPriority(),
                        task.isCompleted())
        );

        // 検証ポイントの確認
        System.out.println("\n=== 検証結果 ===");
        System.out.println("1. 完了タスクが含まれていないか: " +
                !sortedTasks.stream().anyMatch(Task::isCompleted));

        System.out.println("2. nullまたは空文字のタイトルが含まれていないか: " +
                !sortedTasks.stream().anyMatch(task ->
                        task.getTitle() == null || task.getTitle().isBlank()));


    }
}