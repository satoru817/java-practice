///**
// * 与えられた文字列の先頭と末尾の空白を削除し、
// * 複数のスペースを1つのスペースに置換するメソッドを実装してください。
// *
// * 例：
// * 入力: "   Hello    World   "
// * 出力: "Hello World"
// *
// * 入力: "Good    Morning     Japan"
// * 出力: "Good Morning Japan"
// */
public class StringProcessor {
    public static String normalizeSpaces(String input) {
        // ここにコードを実装してください
        return input.trim().replaceAll("\\s+"," ");

    }
}

