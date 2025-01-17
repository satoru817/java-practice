import Exception.InvalidShapeSizeException;

public class Circle extends Shape{
    private double radius;

    public Circle(String color,double radius) throws InvalidShapeSizeException {
        super(color);
        if(radius<=0){
            throw  new InvalidShapeSizeException("半径の値が不正です。");
        }

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
    void resize(double factor) throws InvalidShapeSizeException {
        if(factor <= 0){
            throw new InvalidShapeSizeException("ファクターが不正です");
        }
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
