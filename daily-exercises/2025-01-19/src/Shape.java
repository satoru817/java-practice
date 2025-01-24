abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 面積を計算する抽象メソッド
    abstract double calculateArea();

    // 図形の情報を表示する具象メソッド
    public void displayInfo() {
        System.out.println("This is a " + name + " with area: " + calculateArea());
    }
}
