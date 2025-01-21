import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Tokyo", "paris", "London", "berlin", "Madrid", "rome");
        for(String city:processCityNames(cities)){
            System.out.println(city);
        }


    }
        /*
    問題：文字列リストの処理

    以下の要件を満たすメソッドを実装してください：

    1. 文字列のリストを受け取り、以下の条件で処理を行うメソッド：
       - 各文字列の先頭が大文字で始まるものだけを抽出
       - 抽出した文字列を長さでソート（昇順）
       - 同じ長さの文字列は辞書順でソート
       - 結果をList<String>として返す

    2. 以下のような入力例で動作すること：

    入力例：
    ["Tokyo", "paris", "London", "berlin", "Madrid", "rome"]

    期待される出力：
    ["London", "Madrid", "Tokyo"]

    注意点：
    - 大文字判定はCharacter.isUpperCase()を使用可能
    - nullや空文字列が含まれる可能性を考慮すること
    - 入力のリストがnullの場合は空のリストを返すこと
    */

    public static List<String> processCityNames(List<String> cities){
        if(cities.isEmpty()){
            return cities;
        }

        return cities.stream()
                .filter(city->city != null && !city.isEmpty())
                .filter(city->Character.isUpperCase(city.charAt(0)))
                .sorted((city1,city2)->{
                    if(city1.length()!=city2.length()){
                        return city1.length()-city2.length();
                    }
                    return city1.compareTo(city2);
                })
                .toList();
    }
}