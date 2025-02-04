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

先ほどのコードの主な改善ポイントを具体的に説明します：

1. **例外処理の不足**
```java
// 例：著者検索での改善案
public List<Book> getAuthorsBook(String author){
    if (author == null || author.trim().isEmpty()) {
        throw new IllegalArgumentException("著者名が不正です");
    }
    return libraryMembers.stream()
        ...
}
```

2. **防御的コピーの不足**
```java
// 現在のコード
public List<Book> getBorrowedBooks() {
    return borrowedBooks;  // リストの直接参照を返している
}

// 改善案
public List<Book> getBorrowedBooks() {
    return new ArrayList<>(borrowedBooks);  // 防御的コピーを返す
}
```

防御的コピーとは？

防御的コピーとは、オブジェクトの内部状態を外部から意図せず変更されることを防ぐためのテクニックです。特にコレクション（List, Set, Map など）を扱う際に重要です。

具体例で説明します：

```java
public class Library {
    private List<Book> books;  // クラスの内部データ
    
    // 悪い例
    public List<Book> getBooks() {
        return books;  // 内部のリストへの参照をそのまま返す
    }
    
    // この場合、以下のような操作が可能になってしまう
    Library library = new Library();
    List<Book> books = library.getBooks();
    books.add(new Book());  // 内部のリストが直接変更されてしまう！
```

これを防御的コピーを使って改善すると：

```java
public class Library {
    private List<Book> books;
    
    // 良い例1：新しいArrayListを作成
    public List<Book> getBooks() {
        return new ArrayList<>(books);  // リストのコピーを返す
    }
    
    // 良い例2：変更不可なリストを返す
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
}

// この場合
Library library = new Library();
List<Book> books = library.getBooks();
books.add(new Book());  // 例外が発生するか、別のリストが変更されるだけ
```

なぜ必要か：
1. カプセル化の原則を守る
2. 意図しない変更を防ぐ
3. スレッドセーフ性を高める
4. バグの発生を防ぐ

他の例：
```java
public class Student {
    private final List<String> courses;
    
    // コンストラクタでも防御的コピーを使う
    public Student(List<String> courses) {
        // 渡されたリストのコピーを保持
        this.courses = new ArrayList<>(courses);
    }
    
    // getterでも防御的コピーを使う
    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }
}
```

このように、防御的コピーを使用することで、クラスの内部状態を安全に保つことができます。

3. **builderパターンの可視性**
```java
// LibraryMemberでbuilderクラスがprivateになっている
private class builder{  // これではbuilderを外部から使用できない
    
// 改善案
public static class builder{  // publicとstaticにする
```

4. **StreamAPIの活用不足**
```java
// 例：getAuthorsBookでの改善案
public List<Book> getAuthorsBook(String author){
    return libraryMembers.stream()
        .map(LibraryMember::getBorrowedBooks)
        .flatMap(List::stream)
        .filter(book -> book.getAuthors().stream()
            .map(String::toUpperCase)
            .anyMatch(str -> str.contains(author.toUpperCase())))
        .distinct()  // 重複除去を追加
        .collect(Collectors.toList());
}
```

5. **コレクションの不変性の保証**
```java
// Book クラスでのリスト処理
public List<String> getAuthors() {
    return Collections.unmodifiableList(authors);  // 変更不可なリストを返す
}
```

はい、似ていますが少し違いがあります：

防御的コピー：`new ArrayList<>(list)`
- 新しいリストを作成して返す
- 返されたリストは変更可能
- メモリを余分に使う
- 完全に独立したコピーが欲しい場合に使用

```java
List<String> original = new ArrayList<>();
original.add("太宰治");

// 防御的コピー
List<String> copy = new ArrayList<>(original);
copy.add("芥川龍之介");  // OK - コピーは変更可能
original.add("夏目漱石"); // originalは影響を受けない
```

不変リスト：`Collections.unmodifiableList(list)`
- 元のリストの変更不可なビューを返す
- 返されたリストは変更不可能
- 追加のメモリをほとんど使わない
- 読み取り専用で十分な場合に使用

```java
List<String> original = new ArrayList<>();
original.add("太宰治");

// 不変リスト
List<String> unmodifiable = Collections.unmodifiableList(original);
unmodifiable.add("芥川龍之介");  // 実行時エラー - 変更不可
original.add("夏目漱石");        // originalの変更は反映される
```

使い分け：
```java
public class Library {
    private List<Book> books = new ArrayList<>();

    // 1. 完全なコピーが必要な場合（変更可能）
    public List<Book> getBooksDefensive() {
        return new ArrayList<>(books);
    }

    // 2. 読み取り専用で十分な場合（変更不可）
    public List<Book> getBooksUnmodifiable() {
        return Collections.unmodifiableList(books);
    }
}
```

選び方：
- 呼び出し側でリストの変更が必要 → 防御的コピー
- 参照のみの場合 → 不変リスト
- パフォーマンスが重要 → 不変リスト
- 完全な独立性が必要 → 防御的コピー

6. **比較の実装の改善**
```java
@Override
public int compareTo(Book b) {
    // nullチェックの追加
    if (b == null) {
        throw new NullPointerException("比較対象のBookがnullです");
    }
    // publishDateのnullチェック
    if (this.publishDate == null || b.publishDate == null) {
        throw new IllegalStateException("publishDateがnullです");
    }
    return b.publishDate.compareTo(this.publishDate);  // 新しい順なので順序を逆に
}
```

7. **テスト容易性の向上**
- インターフェースの導入
- 依存性の注入
- メソッドの単一責任の明確化

これらの改善を加えることで、より堅牢で保守性の高いコードになります。これらのポイントを意識して、先ほど出題した在庫管理システムの問題に取り組んでみてください。


図書館システムを例に、インターフェースの導入を説明します。

現在のコード（インターフェースなし）：
```java
public class LibraryService {
    private final List<LibraryMember> libraryMembers;

    public List<Book> getLoanedBooks() { ... }
    public List<Book> getAuthorsBook(String author) { ... }
    public List<LibraryMember> getExpiredMember() { ... }
}
```

インターフェースを導入した場合：
```java
// インターフェース：サービスの契約を定義
public interface LibraryService {
    List<Book> getLoanedBooks();
    List<Book> getAuthorsBook(String author);
    List<LibraryMember> getExpiredMember();
}

// 実装クラス
public class LibraryServiceImpl implements LibraryService {
    private final List<LibraryMember> libraryMembers;

    @Override
    public List<Book> getLoanedBooks() { ... }

    @Override
    public List<Book> getAuthorsBook(String author) { ... }

    @Override
    public List<LibraryMember> getExpiredMember() { ... }
}
```

なぜ良いのか：

1. **テストが容易になる**
```java
// テスト用のモック実装が作りやすい
public class MockLibraryService implements LibraryService {
    @Override
    public List<Book> getLoanedBooks() {
        return Arrays.asList(new Book("test1"), new Book("test2"));
    }
    // ...
}
```

2. **実装の切り替えが容易**
```java
// インメモリ実装
public class InMemoryLibraryService implements LibraryService { ... }

// データベース実装
public class DatabaseLibraryService implements LibraryService { ... }

// キャッシュ対応実装
public class CachedLibraryService implements LibraryService { ... }
```

3. **依存性の注入が容易**
```java
public class LibraryController {
    private final LibraryService libraryService;  // インターフェースに依存

    // どの実装を使うかは外部から注入できる
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
}
```

4. **API契約の明確化**
```java
public interface LibraryService {
    /**
     * 貸出中の本のリストを取得します
     * @return 貸出中の本のリスト（出版日の新しい順）
     * @throws LibraryException 取得に失敗した場合
     */
    List<Book> getLoanedBooks() throws LibraryException;
    // ...
}
```

使用例：
```java
// 本番環境
LibraryService service = new LibraryServiceImpl();
LibraryController controller = new LibraryController(service);

// テスト環境
LibraryService mockService = new MockLibraryService();
LibraryController testController = new LibraryController(mockService);
```

インターフェースを導入することで：
- テストが書きやすくなる
- コードの結合度が下がる
- 実装の変更が容易になる
- APIの契約が明確になる

といったメリットが得られます。

はい、その通りです。@Serviceアノテーションを付けたクラスが、Spring Frameworkによって自動的に注入される実装となります。

例えば：
```java
// 本番環境用の実装
@Service
public class RealLibraryService implements LibraryService {
    // 実際のデータベース処理など
}

// テスト環境用の実装
@Service("mockLibraryService")  // 名前を付けることも可能
public class MockLibraryService implements LibraryService {
    // テスト用のダミーデータを返すなど
}
```

コントローラ側での使用：
```java
@Controller
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
}
```

設定の切り替え方：

1. プロファイルを使用する場合：
```java
// 本番用実装
@Service
@Profile("production")
public class RealLibraryService implements LibraryService {
    // 本番環境用の実装
}

// テスト用実装
@Service
@Profile("test")
public class MockLibraryService implements LibraryService {
    // テスト用の実装
}
```

2. 設定クラスで指定する場合：
```java
@Configuration
@Profile("production")
public class ProductionConfig {
    @Bean
    public LibraryService libraryService() {
        return new RealLibraryService();
    }
}

@Configuration
@Profile("test")
public class TestConfig {
    @Bean
    public LibraryService libraryService() {
        return new MockLibraryService();
    }
}
```

実行時のプロファイル指定：
- application.propertiesで指定：`spring.profiles.active=test`
- 起動時の引数で指定：`--spring.profiles.active=test`

このように、@Serviceアノテーションとプロファイルを組み合わせることで、環境に応じて異なる実装を簡単に切り替えることができます。

--これは知らなかったな。。。