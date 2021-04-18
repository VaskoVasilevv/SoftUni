package JavaOOP.Polymorphism.Lab.shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;



    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
    public Double getPerimeter() {
        return this.perimeter;
    }

    protected Double getArea() {
        return this.area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    protected abstract Double calculateArea();

    protected abstract Double calculatePerimeter();

}
