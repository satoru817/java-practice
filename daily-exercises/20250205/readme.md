はい、基本的な文字列操作の問題を出します。商品管理システムに関連した実践的な問題です。

## 問題：
商品コードの形式チェックと変換を行う必要があります。以下の仕様に従って、商品コードの処理を実装してください。

### 商品コードの仕様：
- フォーマット: "AA-999-XX"
    - 最初の2文字: アルファベット大文字
    - 中央の3文字: 数字
    - 最後の2文字: アルファベット大文字
    - 区切り文字: ハイフン（-）

### 要件：
1. 商品コードが正しい形式かチェックするメソッド
2. 小文字で入力された場合は大文字に変換
3. スペースが含まれている場合は削除
4. ハイフンが入力されていない場合は適切な位置にハイフンを挿入

### 入力例:
```
"AB-123-XY"    -> 正しい形式
"ab-123-xy"    -> 大文字に変換が必要
"AB123XY"      -> ハイフン挿入が必要
"AB -123- XY"  -> スペース削除が必要
"A1-123-XY"    -> 不正な形式
```

次のメソッドを実装してください：
```java
public class ProductCodeFormatter {
    // 商品コードが正しい形式かチェック
    public static boolean isValidFormat(String code) {
        // 実装してください
    }

    // 商品コードを正しい形式に変換
    public static String formatCode(String code) {
        // 実装してください
    }
}
```

基本的な文字列操作のメソッド（`toUpperCase()`, `trim()`, `replaceAll()`, `substring()` など）を使用して実装してみてください。

この問題は10-15分程度で解けるはずです。準備ができたら実装を始めてください。

良い実装ですね。いくつかの優れたポイントと、さらに改善できる点について説明させていただきます：

### 優れている点 👍

1. **定数の活用**
  - 正規表現パターンを定数として定義
  - コンパイル済みのPatternを再利用

2. **段階的な処理**
  - 既に正しい形式かチェック
  - スペース削除と大文字変換
  - ハイフン追加
    という論理的な流れで実装

3. **正規表現の活用**
  - 2つの異なるパターンを使用（ハイフンあり/なし）
  - `\\s+` での空白文字の除去

### 改善できる点 🔧

1. **エラー処理の明確化**
```java
public static String formatCode(String code) {
    if (code == null) {
        return null;
    }
    // ... 残りの実装
}
```

2. **メソッドの分割**
```java
private static String removeNonAlphanumeric(String code) {
    return code.replaceAll("[^A-Z0-9]", "");
}

private static String insertHyphens(String code) {
    StringBuilder sb = new StringBuilder(code);
    sb.insert(2, "-");
    sb.insert(6, "-");
    return sb.toString();
}
```

3. **コメントの追加**
```java
/** 正規表現：AA-999-XX形式（ハイフンあり） */
private final static String VALID_FORMAT = "^[A-Z]{2}-[0-9]{3}-[A-Z]{2}$";

/** 正規表現：AA999XX形式（ハイフンなし） */
private final static String NEARLY_VALID_FORMAT = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$";
```

### テストケース案

```java
@Test
public void testFormatCode() {
    assertEquals("AB-123-XY", ProductCodeFormatter.formatCode("AB-123-XY"));
    assertEquals("AB-123-XY", ProductCodeFormatter.formatCode("ab-123-xy"));
    assertEquals("AB-123-XY", ProductCodeFormatter.formatCode("AB123XY"));
    assertEquals("AB-123-XY", ProductCodeFormatter.formatCode("AB 123 XY"));
    assertNull(ProductCodeFormatter.formatCode("A1-123-XY"));
    assertNull(ProductCodeFormatter.formatCode(null));
}
```

総じて、基本的な文字列操作の知識を活かした良い実装ができていると思います。正規表現を使用した検証とStringBuilderを使用した文字列操作の組み合わせが効果的です。

--実際30分くらい調べながら書いた。まだまだ甘い。  