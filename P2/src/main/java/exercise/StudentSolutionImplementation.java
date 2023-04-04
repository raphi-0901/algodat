package main.java.exercise;

import main.java.framework.StudentInformation;
import main.java.framework.StudentSolution;

import java.util.ArrayList;
import java.util.List;

public class StudentSolutionImplementation implements StudentSolution {
    @Override
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "", // Vorname
                "", // Nachname
                "" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für die Heapify-Up-Operation
    public void heapifyUp(PriorityQueue priorityQueue, int index) {

    }

    // Implementieren Sie hier Ihre Lösung für die Heapify-Down-Operation
    public void heapifyDown(PriorityQueue priorityQueue, int index) {

    }

    // Implementieren Sie hier Ihre Lösung für den Algorithmus von Prim
    public double prim(Graph g, PriorityQueue q, int[] predecessors) {

        return 0;
    }

    // Implementieren Sie hier Ihre Lösung für die Find-Set-Operation
    public int findset(UnionFindDataStructure unionFindDataStructure, int vertexId) {

        return 0;
    }

    // Implementieren Sie hier Ihre Lösung für den Algorithmus von Kruskal
    public double kruskal(Graph g, UnionFindDataStructure u, boolean[] chosenEdges) {

        return 0;
    }

}
