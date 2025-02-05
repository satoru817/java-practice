public class Main {
    public static void main(String[] args) {

        String str1 = "AB-123-XY";
        String str2 = "ab-123-xy";

        System.out.println(ProductCodeFormatter.isValidFormat(str1));
        System.out.println(ProductCodeFormatter.isValidFormat(str2));
    }
}