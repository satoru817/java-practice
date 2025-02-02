はい、素晴らしい実装ですね！簡潔で効率的な解答です。

ただし、一つだけ改善点があります。それは `null` チェックです。このメソッドに `null` が渡された場合、`NullPointerException` が発生してしまいます。

以下のように修正するとより堅牢なコードになります：

```java
public static String normalizeSpaces(String input) {
    if (input == null) {
        return null;  // または "" やその他の適切な値
    }
    return input.trim().replaceAll("\\s+", " ");
}
```

あなたの実装の優れている点：
1. `trim()` で先頭と末尾の空白を効率的に削除
2. 正規表現 `\\s+` を使用して複数の空白文字を一括で処理
3. メソッドチェーンで処理を簡潔に記述

次の問題を出題させていただきますか？より複雑な文字列操作の問題に進みましょう。


素晴らしい実装ですね！Stream APIとラムダ式を効果的に活用できています。

特に優れている点：
1. Stream APIの `chars()` メソッドを使用して文字列をIntStreamに変換
2. `filter` と `count` を使用した簡潔な実装
3. `Character.toLowerCase()` で大文字小文字の区別なく比較
4. null チェックと適切な例外スロー

可能な別解としては：
```java
public static int countCharOccurrences(String str, char target) {
    if (str == null) {
        throw new IllegalArgumentException("input string is invalid");
    }
    
    String lowerStr = str.toLowerCase();
    char lowerTarget = Character.toLowerCase(target);
    
    int count = 0;
    for (char c : lowerStr.toCharArray()) {
        if (c == lowerTarget) {
            count++;
        }
    }
    return count;
}
```

あなたの解答の方が：
- より簡潔
- より宣言的
- より現代的なJavaの機能を活用
  という点で優れています。

次は、もう少し複雑な問題に進みましょうか？コレクションの操作を含む問題を出題させていただきます。





良い実装ですね！Stream APIの機能を効果的に活用できています。

ただし、問題の要件に含まれているいくつかのバリデーションが抜けています。完全な実装にするには、以下のような修正が必要です：

```java
public static double processNumbers(List<Integer> numbers, int n) {
    // 入力値のバリデーション
    if (numbers == null) {
        throw new IllegalArgumentException("入力リストがnullです");
    }
    if (n <= 0) {
        throw new IllegalArgumentException("nは1以上である必要があります");
    }

    return numbers.stream()
            .filter(num -> num % 2 == 0)
            .map(num -> num * 2)
            .sorted(Comparator.reverseOrder())
            .limit(n)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);  // 偶数が存在しない場合は0.0を返す
}
```

あなたの実装の優れている点：
1. Stream APIの適切なメソッドチェーン
2. `Comparator.reverseOrder()`による降順ソート
3. `mapToInt`での型変換と`average()`の使用
4. メソッドチェーンによる簡潔な記述

改善点：
1. null チェックの追加
2. nの値チェックの追加
3. 偶数が存在しない場合の戻り値を`RuntimeException`ではなく`0.0`に変更

次は、もう少し複雑なコレクション操作の問題を出題しましょうか？例えば、複数のリストの操作や、より複雑な集計処理を含む問題などはいかがでしょうか？



なるほど、良い実装ですね！Stream APIを効果的に使用できています。

ただし、いくつかの改善点があります：

1. バリデーションの追加が必要です->AIに示すときにそこを見せてなかった
2. 小数点の丸め処理が実装されていません
3. 比較処理をもう少し簡潔に書けます

改善したバージョンはこちらです：

```java
public static Map<String, Double> getTopStudents(Map<String, List<Integer>> scores, int n) {
    // バリデーション
    if (scores == null) {
        throw new IllegalArgumentException("scores must not be null");
    }
    if (n <= 0) {
        throw new IllegalArgumentException("n must be positive");
    }

    return scores.entrySet().stream()
        .filter(entry -> !entry.getValue().isEmpty())  // 空リストの除外
        .map(entry -> new AbstractMap.SimpleEntry<>(
            entry.getKey(),
            Math.round(entry.getValue().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0) * 100.0) / 100.0  // 小数点第2位で四捨五入
        ))
        .filter(entry -> entry.getValue() >= 60)
        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())  // より簡潔な比較
        .limit(n)
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (v1, v2) -> v1,  // 同じキーの場合の処理
            LinkedHashMap::new  // 順序保持
        ));
}
```

あなたの実装の優れている点：
1. Stream APIを使用した効率的な処理
2. map操作での適切なデータ変換
3. filterによる条件絞り込み

改善のポイント：
1. `Comparator.comparingByValue().reversed()`を使用するとソートがより簡潔に書けます
2. `LinkedHashMap`を使用することで順序が保持されます
3. 小数点の丸め処理の追加
4. バリデーションチェックの追加

次は、もっと複雑なオブジェクト指向の問題を出題しましょうか？クラス設計を含む問題に進みたいと思います。

/**
* 図書館の本の貸し出し管理システムの一部を実装してください。
* 以下の要件を満たすクラスを作成してください。
*
* 要件:
* 1. Bookクラス
*    - 本のID、タイトル、著者、貸出状態を管理
*    - 本の貸出・返却の機能を提供
*    - 貸出中の本は再度貸し出せない
*
* 2. Userクラス
*    - ユーザーID、名前、貸出中の本のリストを管理
*    - 一度に借りられる本は最大3冊まで
*
* 3. LibraryManagerクラス
*    - 本の貸し出し・返却処理を管理
*    - 貸出・返却時に適切な例外処理を実装
*    - ユーザーごとの貸出状況を追跡
*
* 期待される動作例：
* Library library = new LibraryManager();
* User user = new User("U001", "田中太郎");
* Book book = new Book("B001", "Java入門", "山田花子");
*
* library.lendBook(user, book);  // 貸出成功
* library.lendBook(user, book);  // 例外: 既に貸出中
* library.returnBook(user, book);  // 返却成功
  */

// ここにクラスを実装してください

良い実装ですね！基本的な機能は実装できています。いくつかの改善点を提案させていただきます：

1. 適切な例外クラスの定義：
```java
public class LibraryException extends RuntimeException {
    public LibraryException(String message) {
        super(message);
    }
}
```

2. Bookクラスの改善：
```java
public class Book {
    private final String id;  // idは変更不可にする
    private final String title;
    private final String author;
    private boolean isLoaned;

    public Book(String id, String title, String author) {
        if (id == null || title == null || author == null) {
            throw new IllegalArgumentException("All parameters must not be null");
        }
        this.id = id;
        this.title = title;
        this.author = author;
        this.isLoaned = false;
    }

    public void lend() {
        if (isLoaned) {
            throw new LibraryException("Book is already loaned: " + title);
        }
        isLoaned = true;
    }

    public void returnBook() {
        if (!isLoaned) {
            throw new LibraryException("Book is not loaned: " + title);
        }
        isLoaned = false;
    }

    // getterのみを提供（setterは不要）
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isLoaned() { return isLoaned; }
}
```

3. Userクラスの改善：
```java
public class User {
    private final String id;
    private String name;
    private final List<Book> borrowedBooks;
    private static final int MAX_BOOKS = 3;

    public User(String id, String name) {
        if (id == null || name == null) {
            throw new IllegalArgumentException("Id and name must not be null");
        }
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= MAX_BOOKS) {
            throw new LibraryException("User has reached maximum number of books");
        }
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        if (!borrowedBooks.remove(book)) {
            throw new LibraryException("User does not have this book");
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }
}
```

4. LibraryManagerの改善：
```java
public class LibraryManager {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public void lendBook(User user, Book book) {
        try {
            book.lend();
            user.borrowBook(book);
        } catch (LibraryException e) {
            throw new LibraryException("Failed to lend book: " + e.getMessage());
        }
    }

    public void returnBook(User user, Book book) {
        try {
            book.returnBook();
            user.returnBook(book);
        } catch (LibraryException e) {
            throw new LibraryException("Failed to return book: " + e.getMessage());
        }
    }

    public List<Book> getBorrowedBooks(User user) {
        return user.getBorrowedBooks();
    }
}
```

主な改善点：
1. イミュータブルな設計（finalフィールドの使用）
2. 適切な例外処理
3. コレクションの不変性の保証
4. バリデーションの強化
5. カスタム例外の導入
6. 定数の使用（MAX_BOOKS）
7. 不要なsetterの削除
8. nullチェックの追加

これらの改善により、より堅牢で保守性の高いコードになります。

次は、もっと複雑なデザインパターンを使用する問題や、並行処理を含む問題などに進みましょうか？

/**
* タスク処理システムを実装してください。
* このシステムは非同期でタスクを処理し、その進捗状況を監視できる必要があります。
*
* 要件:
* 1. タスクは優先度（HIGH, MEDIUM, LOW）を持つ
* 2. タスクの状態（WAITING, RUNNING, COMPLETED, FAILED）を管理
* 3. 優先度の高いタスクが優先して実行される
* 4. 同時に実行できるタスクの数は最大3つまで
* 5. タスクの実行状態が変化した際にオブザーバーに通知
*
* 実装するクラス：
* - Task: タスクの基本情報を保持
* - TaskExecutor: タスクの実行を管理
* - TaskObserver: タスクの状態変化を監視
* - TaskManager: 全体の管理を行う（Singleton）
*
* 使用例：
* TaskManager manager = TaskManager.getInstance();
* Task task = new Task("データ処理", Priority.HIGH);
* manager.addTask(task);
* manager.startProcessing();
*
* ヒント：
* - ExecutorServiceを使用してタスクを実行
* - Observerパターンで状態変化を通知
* - PriorityBlockingQueueで優先度付きキューを実装
    */

// ここにクラスを実装してください