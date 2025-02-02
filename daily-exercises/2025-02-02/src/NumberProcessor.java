import java.util.Comparator;
import java.util.List;

///**
// * 整数のリストを受け取り、以下の条件で処理を行うメソッドを実装してください：
// * 1. リスト内の偶数のみを抽出
// * 2. 各要素を2倍にする
// * 3. 結果を降順（大きい順）にソート
// * 4. 上位N個の要素の平均値を計算して返す
// *
// * 例：
// * input: [1, 2, 3, 4, 5, 6, 7, 8], n = 3
// * 偶数のみ: [2, 4, 6, 8]
// * 2倍: [4, 8, 12, 16]
// * 降順ソート: [16, 12, 8, 4]
// * 上位3つの平均: (16 + 12 + 8) / 3 = 12.0
// *
// * 注意事項：
// * - 入力リストがnullの場合は IllegalArgumentException をスロー
// * - nが0以下の場合は IllegalArgumentException をスロー
// * - nが偶数の個数より大きい場合は、存在する偶数のみで平均を計算
// * - 該当する偶数が存在しない場合は0.0を返す
// *
// * @param numbers 整数のリスト
// * @param n 平均を計算する要素数
// * @return 条件を満たす要素の平均値
// */
public class NumberProcessor {
    public static double processNumbers(List<Integer> numbers, int n) {
        // ここにコードを実装してください
        return numbers.stream()
                .filter(num->num%2 == 0)
                .map(num->num*2)
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .mapToInt(Integer::intValue)
                .average().orElseThrow(()-> new RuntimeException("無効なListです"));
    }
}
