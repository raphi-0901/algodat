package main.java.exercise;

import main.java.framework.Instance;

public class InstanceImplementation implements Instance {

    private String groupName;
    private int number;
    private int[] numbers;
    private Point[] points;
    private int sum;
    private int maxSolution;
    private ClosestPair pointSolution;
    private boolean sumSolution;

    public InstanceImplementation(String groupName, int number, int[] numbers, Point[] points, int sum, int maxSolution, ClosestPair pointSolution, boolean sumSolution) {
        this.groupName = groupName;
        this.number = number;
        this.numbers = numbers;
        this.points = points;
        this.sum = sum;
        this.maxSolution = maxSolution;
        this.pointSolution = pointSolution;
        this.sumSolution = sumSolution;
    }

    @Override
    public String getGroupName() {
        return this.groupName;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public Point[] getPoints() {
        return points;
    }

    public int getSum() {
        return sum;
    }

    public int getMaxSolution() {
        return maxSolution;
    }

    public ClosestPair getPointSolution() {
        return pointSolution;
    }

    public boolean getSumSolution() {
        return sumSolution;
    }
}
