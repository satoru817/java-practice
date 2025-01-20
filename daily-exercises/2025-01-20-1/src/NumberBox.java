public class NumberBox<T extends Number> {
    private T number;

    public NumberBox(T number){
        this.number = number;
    }

    public T getNumber(){
        return number;
    }

    //public static <T> void printBox(NumberBox<T> box) { }

    // B
    public static<T extends Number> void printBox(NumberBox<T> box) {
        System.out.println(box.number);
    }

    // C
    //public static void printBox(NumberBox<?> box) { }

    // D
    public static <T extends Number> T getMaxValue(NumberBox<T> box1, NumberBox<T> box2) { return null; }
}
