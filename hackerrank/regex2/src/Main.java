import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA: ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART: GROOVY:OBJECTIVEC";
        List<String> languages = Arrays.stream(str.split(":")).map(lan->lan.trim()).toList();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        while(num>0){
            String req = scanner.nextLine();
            String lang = req.substring(6);
            if(languages.contains(lang)){
                System.out.println("VALID");
            }else{
                System.out.println("INVALID");
            }
            num--;
        }

    }
}