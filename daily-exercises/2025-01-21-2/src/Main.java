public class Main {
    public static void main(String[] args) {

        StringProcessor processor = new StringProcessor();
        String[] cities = {"tokyo", "London", "Paris", "Madrid", "berlin"};
        for(String city:processor.processStrings(cities)){
            System.out.println(city);
        }

    }
}