public abstract class Shape implements Comparable<Shape> {
    abstract double getArea();
    abstract String getType();
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
