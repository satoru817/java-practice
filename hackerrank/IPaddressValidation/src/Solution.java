import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            validateIPAddress(str);
        }
    }

    public static void validateIPAddress(String address){
        Pattern p = Pattern.compile("\\d$");
        Matcher m = p.matcher(address);
        if(!m.find()){
            System.out.println("false");
        }else{
            List<String> strings = Arrays.stream(address.split("\\.")).toList();
            if(strings.size()!=4){
                System.out.println("false");
            }else{
                AtomicReference<Boolean> b = new AtomicReference<>(true);
                strings.forEach(str->{
                    if(!str.matches("\\d+")||str.length()>3 || Integer.parseInt(str)>255){
                        b.set(false);
                    }
                });

                if(!b.get()){
                    System.out.println("false");
                }else{
                    System.out.println("true");
                }
            }
        }
    }
}