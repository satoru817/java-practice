public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        if(width <= 0 || height <= 0){
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return width*height;
    }

    @Override
    public String toString(){
        return String.format(
                "Rectangle{width:%s,height%s}",
                width,
                height
        );
    }
}
