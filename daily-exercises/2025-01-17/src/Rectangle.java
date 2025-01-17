public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color,double width,double height){
        super(color);
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

    @Override
    void resize(double factor) {
        width *= factor;
        height *= factor;
    }


    @Override
    public void draw() {
        String message = String.format(
                "%s色の正方形を描画、幅:%s 高さ:%s",
                getColor(),
                getWidth(),
                getHeight()
        );
        System.out.println(message);
    }
}
