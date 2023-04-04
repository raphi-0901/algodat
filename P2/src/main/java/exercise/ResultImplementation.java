package main.java.exercise;

import main.java.framework.PersistAs;
import main.java.framework.Result;

public class ResultImplementation implements Result {

    @PersistAs("duration")
    private long duration;

    private int[] parents;

    @PersistAs("relevantVertices")
    private String relevantVerticesString;

    private double totalWeight;

    @PersistAs("numberOfRelevantVertices")
    private int numberOfRelevantVertices;

    private int[][] selectedEdges;

    @PersistAs("selectedEdges")
    private String selectedEdgesString;

    public ResultImplementation(long duration, int[] relevantVertices, int[] parents, double totalWeight, int[][] selectedEdges) {
        this.duration = duration;
        this.parents = parents;
        this.totalWeight = totalWeight;
        this.numberOfRelevantVertices = relevantVertices.length;

        String relevantVerticesString = "";
        for (int i = 0; i < relevantVertices.length; i++) {
            if (i != 0) {
                relevantVerticesString += "|";
            }
            relevantVerticesString += relevantVertices[i];
        }

        String selectedEdgesString = "";
        for (int i = 0; i < selectedEdges.length; i++) {
            if (i != 0) {
                selectedEdgesString += "|";
            }
            selectedEdgesString += (selectedEdges[i][0] + "-" + selectedEdges[i][1]);
        }

        this.relevantVerticesString = relevantVerticesString;
        this.selectedEdges = selectedEdges;
        this.selectedEdgesString = selectedEdgesString;
    }

    public int[] getParents() {
        return parents;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int[][] getSelectedEdges() {
        return selectedEdges;
    }
}
