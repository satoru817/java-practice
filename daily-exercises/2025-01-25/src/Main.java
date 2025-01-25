import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,2,7,8,3,6};
        List<Integer> edited = processNumbers(nums);
        for(Integer num:edited){
            System.out.println(num);
        }

        String[] pets = {"dog", "cat", "Lion", "a", "mouse", "Cat"};
        List<String> editedPet = processStrings(pets);
        for(String pet : editedPet){
            System.out.println(pet);
        }

        String[] values = {"123", "abc", "17", "22", "11"};
        System.out.println(countPrimeNumbers(values));
    }

    public static List<Integer> processNumbers(int[] numbers){
        return Arrays.stream(numbers)
                .filter(num->num%2 == 0)
                .map(num->num*2)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<String> processStrings(String[] words) {
        return Arrays.stream(words)
                .filter(word->word.length()>=3)
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .toList();
    }

    public static long countPrimeNumbers(String[] values) {
        String regex = "[1-9]\\d*";
        return Arrays.stream(values)
                .filter(value->value.matches(regex))
                .filter(value->isPrime(Integer.parseInt(value)))
                .count();
    }


    public static boolean isPrime(int num) {
        // 素数は2以上の整数
        if (num <= 1) {
            return false;
        }

        // 2は素数
        if (num == 2) {
            return true;
        }

        // 偶数は素数ではない
        if (num % 2 == 0) {
            return false;
        }

        // 3以上の奇数を試す (平方根までチェック)
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true; // 素数
    }
}
