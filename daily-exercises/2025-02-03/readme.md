あなたのJavaスキルについて、提供された学習記録から分析すると、特に以下の分野での強化が必要そうです。それに基づいて実践的な問題を出題させていただきます。

以下のような図書館システムの一部を実装する問題に取り組んでみましょう：

```java
public class Book {
    private final String isbn;
    private final String title;
    private List<String> authors;
    private boolean isAvailable;
    private LocalDate publishDate;
    
    // コンストラクタとgetterは実装済みとします
}

public class LibraryMember {
    private final String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private LocalDate membershipStartDate;
    
    // コンストラクタとgetterは実装済みとします
}
```

以下の要件を満たすコードを実装してください：

1. `LibraryService` クラスを作成し、以下のメソッドを実装してください：
    - 会員の貸出中の本をソートして返すメソッド（出版日の新しい順）
    - 特定の著者の本を検索するメソッド（大文字小文字を区別しない）
    - 期限切れの会員を抽出するメソッド（会員期限は1年とする）

2. バリデーションとエラー処理を適切に実装してください：
    - 入力値のnullチェック
    - 不正な日付データのチェック
    - カスタム例外の使用

3. Stream APIを使用して効率的に実装してください。

この問題は以下の要素を確認することを意図しています：
- Stream APIの実践的な使用
- 例外処理の適切な実装
- Optional型の活用
- イミュータブルなオブジェクト設計
- 日付操作の理解

回答をお願いします。