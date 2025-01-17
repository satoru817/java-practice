public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    @Override
    double getArea() {
        return width*height;
    }

    @Override
    String getType() {
        return this.getClass().getName();
    }


}
