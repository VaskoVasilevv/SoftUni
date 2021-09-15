package Abstraction.Lab.PiontInRectangele;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterOrEqualX(Point2D other){
       return this.x >= other.x;
    }
    public boolean isWithEqualX(Point2D other){
        return this.x == other.x;
    }
    public boolean isLessOrEqualX(Point2D other){
        return this.x <= other.x;
    }
    public boolean isGreaterOrEqualY(Point2D other){
        return this.y >= other.y;
    }
    public boolean isWithEqualY(Point2D other){
        return this.y== other.y;
    }
    public boolean isLessOrEqualY(Point2D other){
        return this.y <= other.y;
    }
}
