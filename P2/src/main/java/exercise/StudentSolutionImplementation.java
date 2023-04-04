package main.java.exercise;

import main.java.framework.StudentInformation;
import main.java.framework.StudentSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentSolutionImplementation implements StudentSolution {
    @Override
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "Raphael", // Vorname
                "Wirnsberger", // Nachname
                "12220836" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für die Heapify-Up-Operation
    public void heapifyUp(PriorityQueue priorityQueue, int index) {
        if (index <= 1) {
            return;
        }

        int j = index / 2;
        if (priorityQueue.getWeight(j) > priorityQueue.getWeight(index)) {
            priorityQueue.swap(index, j);
            heapifyUp(priorityQueue, j);
        }
    }

    // Implementieren Sie hier Ihre Lösung für die Heapify-Down-Operation
    public void heapifyDown(PriorityQueue priorityQueue, int index) {
        if (2 * index > priorityQueue.length() - 1) {
            return;
        }

        int newIndex;
        if (2 * index == priorityQueue.length() - 1) {
            newIndex = 2 * index;
        } else {
            newIndex = priorityQueue.getWeight(2 * index) < priorityQueue.getWeight(2 * index + 1)
                    ? 2 * index
                    : 2 * index + 1;
        }

        if (priorityQueue.getWeight(newIndex) < priorityQueue.getWeight(index)) {
            priorityQueue.swap(index, newIndex);
            heapifyDown(priorityQueue, newIndex);
        }
    }

    // Implementieren Sie hier Ihre Lösung für den Algorithmus von Prim
    public double prim(Graph g, PriorityQueue q, int[] predecessors) {
        boolean[] discovered = new boolean[g.numberOfVertices()];
        double[] weights = new double[g.numberOfVertices()];

        // add all vertices to queue
        for (int i = 1; i <= g.numberOfVertices(); i++) {
            if (g.isRelevant(i)) {
                weights[i - 1] = Double.MAX_VALUE;
                q.add(Double.MAX_VALUE, i);
            }
        }

        boolean first = true;
        while (!q.isEmpty()) {
            int idOfFirstVertex = q.removeFirst();

            // 0 means not already set
            // if there is no predecessor already defined in the array,
            // set the current vertexId as predecessor
            if (predecessors[idOfFirstVertex] == 0 || first) {
                first = false;
                predecessors[idOfFirstVertex] = idOfFirstVertex;
                weights[idOfFirstVertex - 1] = 0;
            }

            discovered[idOfFirstVertex - 1] = true;
            for (int neighborId : g.getNeighbors(idOfFirstVertex)) {
                if (g.isRelevant(neighborId)) {
                    double edgeWeightToNeighbor = g.getEdgeWeight(idOfFirstVertex, neighborId);

                    if (discovered[neighborId - 1]) {
                        continue;
                    }

                    // decrease weight if needed
                    if (edgeWeightToNeighbor < weights[neighborId - 1]) {
                        weights[neighborId - 1] = edgeWeightToNeighbor;
                        q.decreaseWeight(edgeWeightToNeighbor, neighborId);
                        predecessors[neighborId] = idOfFirstVertex;
                    }
                }
            }
        }

        double sum = 0;
        for (double weight : weights) {
            sum += weight;
        }
        return sum;
    }

    // Implementieren Sie hier Ihre Lösung für die Find-Set-Operation
    public int findset(UnionFindDataStructure unionFindDataStructure, int vertexId) {
        int parentId = unionFindDataStructure.getParent(vertexId);

        if (parentId == vertexId) {
            return vertexId;
        }

        return findset(unionFindDataStructure, parentId);
    }

    // Implementieren Sie hier Ihre Lösung für den Algorithmus von Kruskal
    public double kruskal(Graph g, UnionFindDataStructure u, boolean[] chosenEdges) {
        int[][] orderedEdges = g.getEdgesOrderedByWeight();
        for (int i = 0; i < orderedEdges.length; i++) {
            int a = orderedEdges[i][0];
            int b = orderedEdges[i][1];
            int representativeId1 = -1;
            int representativeId2 = -1;

            if (g.isRelevant(a)) {
                representativeId1 = u.findset(a);
                // 0 means no parent
                if (representativeId1 == 0) {
                    u.makeset(a);
                    representativeId1 = a;
                }
            }

            if (g.isRelevant(b)) {
                representativeId2 = u.findset(b);
                if (representativeId2 == 0) {
                    u.makeset(b);
                    representativeId2 = b;
                }
            }

            if (representativeId1 == representativeId2) {
                continue;
            }

            if (representativeId1 != -1 && representativeId2 != -1) {
                chosenEdges[i] = true;
                u.union(representativeId1, representativeId2);
                continue;
            }

            if (representativeId1 != -1) {
                u.union(representativeId1, representativeId1);
                continue;
            }

            u.union(representativeId2, representativeId2);
        }

        double sum = 0;
        for (int i = 0; i < chosenEdges.length; i++) {
            if (chosenEdges[i]) {
                sum += g.getEdgeWeight(orderedEdges[i][0], orderedEdges[i][1]);
            }
        }
        return sum;
    }
}
