import java.util.Arrays;

public class CharacterCounter {
    public static int countCharOccurrences(String str,char target){
        if(str==null){
            throw new IllegalArgumentException("input string is invalid");
        }

        return (int) str.chars().filter(c1->Character.toLowerCase(c1)==Character.toLowerCase(target)).count();
    }
}
