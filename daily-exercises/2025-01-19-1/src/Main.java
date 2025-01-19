import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");


    }

    public List<Integer> collectionManipulation(List<Integer> list){
        return list.stream()
                .distinct()
                .filter(num->num%2 ==0)
                .sorted(Comparator.comparingInt(num->num))
                .toList();
    }

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    public boolean isValidAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(
                    String.format("年齢は%d以上にしてください。入力値: %d", MIN_AGE, age)
            );
        }

        if (age > MAX_AGE) {
            throw new IllegalArgumentException(
                    String.format("年齢は%d以下にしてください。入力値: %d", MAX_AGE, age)
            );
        }

        return true;
    }

    // オーバーロードしたバージョン（より柔軟な使用のため）
    public boolean isValidAge(Integer age) {
        if (age == null) {
            throw new IllegalArgumentException("年齢がnullです");
        }
        return isValidAge(age.intValue());
    }
}