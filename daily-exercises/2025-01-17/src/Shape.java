public abstract class Shape implements Comparable<Shape> ,Drawable{
    private String color;
    public Shape(String color){
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    abstract double getArea();
    abstract String getType();
    abstract void resize(double factor);
    boolean isLargerThan(Shape other){
        return this.getArea() > other.getArea();
    }

    public int compareTo(Shape o) {
        if(this.getArea()==o.getArea()){
            return 0;
        }else if(this.getArea()>o.getArea()){
            return 1;
        }else{
            return -1;
        }
    }

}
