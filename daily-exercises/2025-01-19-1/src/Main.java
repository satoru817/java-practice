import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");


    }

    public List<Integer> collectionManipulation(List<Integer> list){
        return list.stream()
                .distinct()
                .filter(num->num%2 ==0)
                .sorted(Comparator.comparingInt(num->num))
                .toList();
    }
}