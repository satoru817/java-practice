import java.util.ArrayList;
import java.util.List;
import Exception.*;

public class ShapeGroup extends Shape{
    List<Shape> shapes;

    public ShapeGroup(String color) {
        super(color);
        this.shapes = new ArrayList<>();
    }

    @Override
    double getArea() {
        return shapes.stream()
                .mapToDouble(shape -> shape.getArea())
                .sum();
    }

    @Override
    String getType() {
        return "Composite";
    }

    @Override
    void resize(double factor) throws InvalidShapeSizeException{
        if(factor <= 0){
            throw new InvalidShapeSizeException("ファクターが不正です");
        }
        shapes.forEach(shape -> shape.resize(factor));
    }

    @Override
    public void draw() {
        shapes.forEach(shape -> shape.draw());
    }

    public void  addShape(Shape shape){
        shapes.add(shape);
    }

    public void removeShape(Shape shape){
        shapes.remove(shape);
    }

    public int getShapeCount(){
        return shapes.size();
    }

    public Shape getShapeAt(int index) throws ShapeNotFoundException {
        if(shapes.size()-1 <= index || index <0){
            throw new ShapeNotFoundException("indexが不正です");
        }
        return shapes.get(index);
    }
}
