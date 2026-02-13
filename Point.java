package week03.geometry;

public class Point {
    private float x;
    private float y;

    public Point() {
        this(0.0f, 0.0f);
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public float distance(Point p) {
        float dx = x - p.x;
        float dy = y - p.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(Point p) {
        float eps = 1e-6f;
        return Math.abs(x - p.x) < eps && Math.abs(y - p.y) < eps;
    }
}
