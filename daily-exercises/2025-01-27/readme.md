あなたの現在のJavaスキルを考慮して、基礎を固めつつ、モダンなJava機能も学べる課題を作成します。



# 課題：図書館蔵書管理システムの実装

以下の要件を満たすシステムを実装してください：

## Part 1: 基本クラスの実装

まず、以下の基本クラスを実装してください：

```java
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final LocalDate publishDate;
    private boolean isAvailable;
    
    // コンストラクタ、getter、setterの実装
    // ISBNの形式バリデーション
    // toString()のオーバーライド
}

public class BookNotFoundException extends Exception {
    // 適切なコンストラクタの実装
}
```

## Part 2: 蔵書管理の実装

次に、蔵書を管理するクラスを実装してください：

```java
public class Library {
    private final List<Book> books;
    
    // 本の追加
    public void addBook(Book book)
    
    // ISBNで本を検索（Optional使用）
    public Optional<Book> findByIsbn(String isbn)
    
    // 著者名で本を検索（Stream API使用）
    public List<Book> findByAuthor(String author)
    
    // 特定の日付以降に出版された本のリストを取得
    public List<Book> findBooksPublishedAfter(LocalDate date)
    
    // 貸出可能な本のみを取得
    public List<Book> getAvailableBooks()
}
```

## Part 3: 応用機能の実装

1. 本の貸出・返却機能
2. 著者ごとの蔵書数の集計
3. 出版年別の蔵書数レポート生成

## 要件

1. すべてのメソッドで適切な例外処理を実装すること
2. Stream APIを積極的に活用すること
3. 可能な限りimmutableな設計を心がけること
4. テストケースを作成すること

## チャレンジ課題

以下の発展的な機能を実装してみましょう：

1. 貸出履歴の管理と統計情報の生成
2. ジャンルによる分類と検索機能
3. 予約システムの実装

この課題は段階的に取り組むことができ、基本的なクラス設計から始めて、徐々により高度な機能を追加していけます。特に気をつけてほしいポイントは：

- 適切なカプセル化
- 不変オブジェクトの活用
- Stream APIの効果的な使用
- Optionalを使用したnull安全な設計
- 例外処理の適切な実装

どの部分から始めたいですか？あるいは具体的なガイダンスが必要な部分はありますか？