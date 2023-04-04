package main.java.exercise;

import main.java.framework.Instance;

import java.util.Set;

public class InstanceImplementation implements Instance {

    private int number;  // Number of instance
    private String groupName;
    private String dataset;
    private int size;
    private boolean sortX;
    private String method;
    private final Point[] pointsOriginal;
    private Point[] points;
    private int a;
    private int b;
    private PointPair closestPointPair;
    private double bestDist;
    private double splitValue;
    private Set<Integer> splitIndex;
    private String splitIndexString;

    // Additionals for Combination
    private double delta;
    private int abar;
    private int bbar;



    public InstanceImplementation(int number, String groupName, String dataset, int size, boolean sortX, String method,
                                  Point[] pointsOriginal, Point[] points,
                                  int a, int b, PointPair closestPointPair, double bestDist,
                                  double splitValue, Set<Integer> splitIndex,
                                  double delta, int abar, int bbar) {
        this.number = number;
        this.groupName = groupName;
        this.dataset = dataset;
        this.size = size;
        this.sortX = sortX;
        this.method = method;
        this.pointsOriginal = pointsOriginal;
        this.points = points;
        this.a = a;
        this.b = b;

        PointPair nullPair = new PointPair(new Point(-1, -1), new Point(-1, -1), Double.POSITIVE_INFINITY);

        if (closestPointPair != null && closestPointPair.equals(nullPair)) {
            this.closestPointPair = null;
        }
        else {
            this.closestPointPair = closestPointPair;
        }

        this.bestDist = bestDist;
        this.splitValue = splitValue;
        this.splitIndex = splitIndex;

        if (splitIndex != null) {
            Integer[] temp = splitIndex.toArray(new Integer[splitIndex.size()]);
            java.util.Arrays.sort(temp);
            this.splitIndexString = "{" + temp[0];
            for (int i = 1; i < temp.length; i++) {
                this.splitIndexString += ", " + temp[i];
            }
            this.splitIndexString += "}";
        }
        else {
            this.splitIndexString = "{-1}";
        }

        this.delta = delta;
        this.abar = abar;
        this.bbar = bbar;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public String getGroupName() {
        return this.groupName;
    }

    public String getDataset() {
        return dataset;
    }

    public int getSize() {
        return size;
    }

    public boolean isSortX() {
        return sortX;
    }

    public String getMethod() {
        return method;
    }

    public Point[] getPointsOriginal() {
        return pointsOriginal;
    }

    public Point[] getPoints() {
        return points;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public PointPair getClosestPointPair() {
        return closestPointPair;
    }

    public double getBestDist() {
        return bestDist;
    }

    public double getSplitValue() {
        return splitValue;
    }

    public Set<Integer> getSplitIndex() {
        return splitIndex;
    }

    public String getSplitIndexString() {
        return splitIndexString;
    }

    public double getDelta() {
        return delta;
    }

    public int getAbar() {
        return abar;
    }

    public int getBbar() {
        return bbar;
    }
}
