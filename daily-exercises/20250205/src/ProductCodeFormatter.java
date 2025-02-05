import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCodeFormatter {
    private final static String VALID_FORMAT = "^[A-Z]{3}-^[0-9]{3}-^[A-Z]{2}";
    private final static Pattern pattern = Pattern.compile(VALID_FORMAT);

    // 商品コードが正しい形式かチェック
    public static boolean isValidFormat(String code) {
        // 実装してください
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }

    // 商品コードを正しい形式に変換
//    public static String formatCode(String code) {
//        // 実装してください
//    }
}