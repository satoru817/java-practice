import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit>{
    private List<T> fruits = new ArrayList<>();

    public void add(T fruit){
        fruits.add(fruit);
    }

    public void setFruits(List<T> fruits){
        this.fruits = fruits;
    }

    public List<T> getFruits(){
        return fruits;
    }
}
