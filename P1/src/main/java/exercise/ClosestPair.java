package main.java.exercise;

public class ClosestPair {
    private Point point1;
    private Point point2;

    public ClosestPair() {}

    public ClosestPair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
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
        ClosestPair closestPair = (ClosestPair) obj;
        return (this.point1.equals(closestPair.point1) && this.point2.equals(closestPair.point2)) ||
                (this.point2.equals(closestPair.point1) && this.point1.equals(closestPair.point2));
    }
}
