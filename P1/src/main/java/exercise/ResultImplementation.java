package main.java.exercise;

import main.java.framework.PersistAs;
import main.java.framework.Result;

public class ResultImplementation implements Result {

    private String problemType;

    @PersistAs("duration")
    private long duration;

    @PersistAs("size")
    private int size;

    private int maxSolution;

    private ClosestPair pointSolution;

    private boolean sumSolution;

    public ResultImplementation(String problemType, long duration, int size, int maxSolution, ClosestPair pointSolution, boolean sumSolution) {
        this.problemType = problemType;
        this.size = size;
        this.duration = duration;
        this.maxSolution = maxSolution;
        this.pointSolution = pointSolution;
        this.sumSolution = sumSolution;
    }

    public String getProblemType() {
        return problemType;
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
