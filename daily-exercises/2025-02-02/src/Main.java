import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

       String str1 = "   Hello    World   ";
       String str2 = "Good    Morning     Japan";

       System.out.println(StringProcessor.normalizeSpaces(str1));
       System.out.println(StringProcessor.normalizeSpaces(str2));

       System.out.println(CharacterCounter.countCharOccurrences(str2,'O'));

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(NumberProcessor.processNumbers(nums,3));

        Map<String,List<Integer>> studentScores = new HashMap<>();
        studentScores.put("田中",List.of(80,65,90));
        studentScores.put("スズキ",List.of(40,50,45));
        studentScores.put("佐藤",List.of(70,85,80));

        Map<String,Double> newMap = StudentScoreProcessor.getTopStudents(studentScores,2);
        System.out.println(newMap);

    }
}