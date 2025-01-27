public class Main {
    public static void main(String[] args) {

        String regex = "^\\d{13}";
        String isbn1 = "1234567890123";
        String isbn2 = "1234567890";
        boolean match1 = isbn1.matches(regex);
        boolean match2 = isbn2.matches(regex);

        System.out.println("isbn1:"+match1);
        System.out.println("isbn2:"+match2);
    }
}