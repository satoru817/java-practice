public class Main {
    public static void main(String[] args) {
        // 基本的なタスクの作成と表示
        Task task1 = new Task(1, "Spring Bootの学習");
        System.out.println("タスク1の作成直後:");
        System.out.println(task1);

        // タスクのステータス変更のテスト
        task1.toggleStatus();
        System.out.println("\nタスク1を完了状態に変更後:");
        System.out.println(task1);

        // 各getterのテスト
        System.out.println("\n各フィールドの値を個別に取得:");
        System.out.println("ID: " + task1.getId());
        System.out.println("タイトル: " + task1.getTitle());
        System.out.println("完了状態: " + task1.isCompleted());
        System.out.println("作成日: " + task1.getCreatedAt());

        // バリデーションのテスト
        System.out.println("\n不正な値でのタスク作成テスト:");
        try {
            Task invalidTask = new Task(2, null);
            System.out.println("このメッセージは表示されないはず");
        } catch (IllegalArgumentException e) {
            System.out.println("正しく例外が発生: " + e.getMessage());
        }

        try {
            Task invalidTask = new Task(2, "   ");
            System.out.println("このメッセージは表示されないはず");
        } catch (IllegalArgumentException e) {
            System.out.println("正しく例外が発生: " + e.getMessage());
        }
    }
}