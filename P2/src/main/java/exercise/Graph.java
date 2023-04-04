package main.java.exercise;

import main.java.framework.graph.BasicGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

public class Graph extends BasicGraph<VertexImplementation, EdgeImplementation> {

    protected Map<Integer, VertexImplementation> relevantVertices;

    public Graph(SimpleWeightedGraph<VertexImplementation, EdgeImplementation> graph, int[] relevantVertices) {
        super(graph);
        this.relevantVertices = new HashMap<>();
        for(VertexImplementation vertex : graph.vertexSet()) {
            int vertexId = vertex.getId();
            for (int i = 0; i < relevantVertices.length; i++) {
                if (relevantVertices[i] == vertexId) {
                    this.relevantVertices.put(vertexId, vertex);
                    break;
                }
            }
        }
    }

    public double getEdgeWeight(int vertexIdStart, int vertexIdEnd) {
        EdgeImplementation edgeImpl = super.edges.get(new Tuple<Integer, Integer>(vertexIdStart, vertexIdEnd));
        if (edgeImpl == null) {
            edgeImpl = super.edges.get(new Tuple<Integer, Integer>(vertexIdEnd, vertexIdStart));
        }

        if (edgeImpl == null) {
            return -1;
        }

        return this.graph.getEdgeWeight(edgeImpl);
    }

    public int[][] getEdgesOrderedByWeight() {
        List<EdgeImplementation> edges = new ArrayList<EdgeImplementation>(this.graph.edgeSet());
        Collections.sort(edges, (EdgeImplementation edge1, EdgeImplementation edge2) -> {
            double weight1 = this.graph.getEdgeWeight(edge1);
            double weight2 = this.graph.getEdgeWeight(edge2);
            if (weight1 < weight2) {
                return -1;
            } else if (weight1 > weight2) {
                return 1;
            } else {
                return 0;
            }
        });
        int[][] orderedEdges = new int[edges.size()][2];
        for (int i = 0; i < edges.size(); i++) {
            orderedEdges[i][0] = edges.get(i).getFrom().getId();
            orderedEdges[i][1] = edges.get(i).getTo().getId();
        }
        return orderedEdges;
    }

    public boolean isRelevant(int vertexId) {
        VertexImplementation vertex = this.relevantVertices.get(vertexId);
        return vertex != null;
    }


}
