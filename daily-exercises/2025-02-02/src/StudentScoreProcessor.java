import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 生徒の試験結果を処理するメソッドを実装してください。
 *
 * 各生徒は複数の科目を受験しており、以下の処理を行います：
 * 1. 各生徒の平均点を計算
 * 2. 平均点が60点以上の生徒のみを抽出
 * 3. 平均点で降順にソート
 * 4. 上位n人の生徒情報（名前と平均点）を返す
 *
 * 入力データ：
 * - key: 生徒の名前
 * - value: その生徒の各科目の点数のリスト
 *
 * 戻り値：
 * - key: 生徒の名前
 * - value: その生徒の平均点
 *
 * 例：
 * 入力: {
 *   "田中": [80, 65, 90],
 *   "鈴木": [40, 50, 45],
 *   "佐藤": [70, 85, 80]
 * }, n = 2
 *
 * 出力: {
 *   "田中": 78.33,  // (80 + 65 + 90) / 3
 *   "佐藤": 78.33   // (70 + 85 + 80) / 3
 * }
 *
 * 制約：
 * - 入力マップがnullの場合は IllegalArgumentException をスロー
 * - nが0以下の場合は IllegalArgumentException をスロー
 * - 点数のリストが空の場合、その生徒は除外する
 * - 平均点は小数点第2位で四捨五入
 */
public class StudentScoreProcessor {
    public static Map<String, Double> getTopStudents(Map<String, List<Integer>> scores, int n) {
        // ここにコードを実装してください
        if(scores == null){
            throw new IllegalArgumentException("入力された点数情報が無効です");
        }

        if(n <= 0){
            throw new IllegalArgumentException("入力された人数の情報が無効です");
        }

        return scores.entrySet().stream()
                .map(entry-> new AbstractMap.SimpleEntry<>(entry.getKey(),entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)))
                .filter(entry->entry.getValue()>=60)
                .sorted((entry1,entry2)->(entry2.getValue()-entry1.getValue()) > 0? 1 :((entry2.getValue()-entry1.getValue())<0 ? -1 :0))
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));


    }
}