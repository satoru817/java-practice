import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCodeFormatter {
    private final static String VALID_FORMAT = "^[A-Z]{2}-[0-9]{3}-[A-Z]{2}$";
    private final static String NEARLY_VALID_FORMAT="^[A-Z]{2}[0-9]{3}[A-Z]{2}$";
    private final static Pattern pattern = Pattern.compile(VALID_FORMAT);
    private final static Pattern nearPattern = Pattern.compile(NEARLY_VALID_FORMAT);

    // 商品コードが正しい形式かチェック
    public static boolean isValidFormat(String code) {
        // 実装してください
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }

    // 商品コードを正しい形式に変換
    public static String formatCode(String code) {
        // 実装してください
        if(ProductCodeFormatter.isValidFormat(code)){
            return code;
        }else{
            String formatted = code.replaceAll("\\s+","").toUpperCase();
            if(ProductCodeFormatter.isValidFormat(formatted)){
                return formatted;
            }else{
                String twiceFormatted = formatted.replaceAll("[^A-Z0-9]","");
                Matcher matcher = nearPattern.matcher(twiceFormatted);
                if(matcher.matches()){
                    StringBuilder sb = new StringBuilder(twiceFormatted);
                    sb.insert(3,"-");
                    sb.insert(6,"-");
                    return sb.toString();
                }
            }


            }
        return null;
    }
}