package main.java.exercise;

public class Point {
    private double x;
    private double y;

    public Point(String point) {
        String[] coordinates = point.split("\\|");
        this.x = Double.parseDouble(coordinates[0]);
        this.y = Double.parseDouble(coordinates[1]);
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public Point(double[] coordinates) {
        this(coordinates[0], coordinates[1]);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getDistance(Point p) {
        double dist = Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        return dist;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "|" + this.getY() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }
}
