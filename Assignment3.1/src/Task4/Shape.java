package Task4;
// shape tine thu toh yk area gho twk loh ya dl but def ka 0 , subclass twy ka color nk override calculateArea() and toString().
public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public double calculateArea(){
        return 0.0;
    }

    @Override
    public String toString() {
        return color + " shape";
    }
}
