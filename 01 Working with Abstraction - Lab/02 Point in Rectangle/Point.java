package pointInRectangle;

public class Point {
    private final int X;
    private final int Y;

    public Point(int coordinateX, int coordinateY) {
        this.X = coordinateX;
        this.Y = coordinateY;
    }

    public boolean greaterThan (Point other) {
        return X >= other.X && Y >= other.Y;
    }

    public boolean smallerThan (Point other) {
        return X <= other.X && Y <= other.Y;
    }
}
