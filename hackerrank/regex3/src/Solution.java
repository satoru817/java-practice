import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str==null||str.equals("")){
            System.out.println(0);
            return;
        }
        String[] words = divide(str);
        if(words.length==1 && words[0]=="" ){
            System.out.println(0);
            return;
        }
        System.out.println(words.length);
        if(words.length>0){
            for(String word: words){
                System.out.println(word);
            }
        }

    }

    public static String[] divide(String str){

        return str.trim().split("[^a-zA-Z]+");
    }
}
