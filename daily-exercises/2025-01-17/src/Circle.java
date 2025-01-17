public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
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


}
