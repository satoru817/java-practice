import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//問題: 文字列配列の処理
//以下の要件を満たすメソッドを実装してください：
//
//文字列配列を受け取り、以下の条件で処理を行うメソッドを作成
//
//        各文字列の先頭が大文字で始まるもののみをフィルタリング
//文字列の長さでソート（昇順）
//同じ長さの場合は辞書順でソート
//        結果を新しいリストとして返す
//
//
//
//例：
//入力:
//期待される出力: ["London", "Madrid", "Paris"]
public class StringProcessor {
    public List<String> processStrings(String[] cities){
        return Arrays.stream(cities)
                .filter(city->city != null && !city.trim().isEmpty())
                .filter(city->Character.isUpperCase(city.charAt(0)))
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo))
                .toList();
    }
}
