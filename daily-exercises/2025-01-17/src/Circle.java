public class Circle extends Shape{
    private double radius;

    public Circle(String color,double radius){
        super(color);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    String getType() {
        return this.getClass().getName();
    }

    @Override
    void resize(double factor) {
        radius *= factor;
    }


    @Override
    public void draw() {
        String message = String.format(
                "%s色の円を描画、半径: %s",
                getColor(),
                getRadius()
        );
        System.out.println(message);
    }
}
