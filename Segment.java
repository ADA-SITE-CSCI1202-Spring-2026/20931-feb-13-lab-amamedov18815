package week03.geometry;

public class Segment {
    private Point p1;
    private Point p2;

    private static final float EPS = 1e-6f;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public Segment(float x1, float y1, float x2, float y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Point getP1() {
        return new Point(p1);
    }

    public void setP1(Point p) {
        p1 = new Point(p);
    }

    public Point getP2() {
        return new Point(p2);
    }

    public void setP2(Point p) {
        p2 = new Point(p);
    }

    public void translate(float dx, float dy) {
        p1.translate(dx, dy);
        p2.translate(dx, dy);
    }

    public float length() {
        return p1.distance(p2);
    }

    public boolean equals(Segment s) {
        return (p1.equals(s.p1) && p2.equals(s.p2)) ||
               (p1.equals(s.p2) && p2.equals(s.p1));
    }

    public float getSlope() {
        float dx = p2.getX() - p1.getX();
        float dy = p2.getY() - p1.getY();

        if (Math.abs(dx) < EPS) {
            return Float.POSITIVE_INFINITY;
        }
        return dy / dx;
    }

    public float getIntercept() {
        float k = getSlope();
        if (Float.isInfinite(k)) {
            return Float.NaN;
        }
        return p1.getY() - k * p1.getX();
    }

    public boolean isOnLine(Point p) {
        float k = getSlope();
        if (Float.isInfinite(k)) {
            return Math.abs(p.getX() - p1.getX()) < EPS;
        }
        return Math.abs(p.getY() - (k * p.getX() + getIntercept())) < 1e-4f;
    }

    public boolean isOnSegment(Point p) {
        if (!isOnLine(p)) return false;

        float minX = Math.min(p1.getX(), p2.getX()) - EPS;
        float maxX = Math.max(p1.getX(), p2.getX()) + EPS;
        float minY = Math.min(p1.getY(), p2.getY()) - EPS;
        float maxY = Math.max(p1.getY(), p2.getY()) + EPS;

        return p.getX() >= minX && p.getX() <= maxX &&
               p.getY() >= minY && p.getY() <= maxY;
    }
}
