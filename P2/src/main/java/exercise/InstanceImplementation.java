package main.java.exercise;

import main.java.framework.Instance;
import org.jgrapht.graph.SimpleWeightedGraph;

public class InstanceImplementation implements Instance {

    private String groupName;
    private int number;
    private SimpleWeightedGraph graph;
    private Graph preparedGraph;
    private double totalWeight;
    private int[] relevantVertices;


    public InstanceImplementation(String groupName, int number, SimpleWeightedGraph graph, double totalWeight, int[] relevantVertices) {
        this.groupName = groupName;
        this.number = number;
        this.graph = graph;
        this.preparedGraph = new Graph(graph, relevantVertices);
        this.totalWeight = totalWeight;
        this.relevantVertices = relevantVertices;
    }

    @Override
    public String getGroupName() {
        return this.groupName;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    public Graph getPreparedGraph() {
        return preparedGraph;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int[] getRelevantVertices() {
        return relevantVertices;
    }
}
