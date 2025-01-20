import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Orange> orangeBox = new FruitBox<>();
        FruitBox<Fruit> fruitBox = new FruitBox<>();

        //FruitBox<Fruit> box1 = appleBox;
        //これはコンパイルエラー：ジェネリッククラスでは継承関係が直接的には引き継がれない。

        FruitBox<? extends Fruit> box2 = appleBox;

        List<Apple> apples = new ArrayList<>();
        List<? extends Fruit> fruits = apples;
    }
}