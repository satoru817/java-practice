import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Pattern p = Pattern.compile("^[Hh][Ii]\\s[^dD]");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        while(num>0){
            String target = scanner.nextLine();
            Matcher m = p.matcher(target);
            if(m.find()){
                System.out.println(target+": match");
            }else{
                System.out.println(target+": not match");
            }
            num--;
        }
    }

}