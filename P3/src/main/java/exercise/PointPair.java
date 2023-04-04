package main.java.exercise;

public class PointPair {

    private Point point1;
    private Point point2;
    private double distance;

    public PointPair() {}

    public PointPair(Point point1, Point point2, double distance) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    public PointPair(Point point1, Point point2) {
        this(point1, point2, point1.getDistance(point2));
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return this.distance;
    }

    public double computeDistance() {
        this.distance = this.point1.getDistance(this.point2);
        return this.distance;
    }

    @Override
    public String toString() {
        if (point1 != null && point2 != null) {
            return this.point1.toString() + " and " + this.point2.toString();
        } else {
            return "(?|?) and (?|?)";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        PointPair pointPair = (PointPair) obj;
        return (this.point1.equals(pointPair.point1) && this.point2.equals(pointPair.point2)) ||
                (this.point2.equals(pointPair.point1) && this.point1.equals(pointPair.point2));
    }
}
