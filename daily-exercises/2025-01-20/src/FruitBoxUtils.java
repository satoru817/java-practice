import java.util.List;

public class FruitBoxUtils {
    public static <T extends Fruit , S extends T>void copy(FruitBox<T> target,FruitBox<S> source){
        for(S fruit :source.getFruits()){
            target.add(fruit);
        }
    }

    public static <T extends Fruit>void swap(FruitBox<T> box1,FruitBox<T> box2){
        List<T> fruits1 = box1.getFruits();
        List<T> fruits2 = box2.getFruits();

        box1.setFruits(fruits2);
        box2.setFruits(fruits1);

    }
}
