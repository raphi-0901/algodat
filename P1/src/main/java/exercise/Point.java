package main.java.exercise;

public class Point {
    private int x;
    private int y;

    public Point(String point) {
        String[] coordinates = point.split("\\|");
        this.x = Integer.parseInt(coordinates[0]);
        this.y = Integer.parseInt(coordinates[1]);
    }

    public Point(Integer[] coordinates) {
        this.x = coordinates[0];
        this.y = coordinates[1];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
