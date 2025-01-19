public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public String toString(){
        return String.format(
                "Circle{radius=%s}",
                radius
        );
    }
}
