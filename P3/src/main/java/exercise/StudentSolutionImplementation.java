package main.java.exercise;

import main.java.framework.StudentInformation;
import main.java.framework.StudentSolution;
import java.util.Random;

public class StudentSolutionImplementation implements StudentSolution {
    @Override
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "", // Vorname
                "", // Nachname
                "" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für Insertion Sort
    public void insertionSort(Point[] points, int a, int b, boolean sortX) {
        
    }

    // Implementieren Sie hier Ihre Lösung für Brute Force
    public PointPair bruteForce(Point[] points, int a, int b) {
        
        return null;
    }

    // Implementieren Sie hier Ihre Lösung für die Bestimmung des Pivotelements
    public double getPivotValue(Point[] points, int a, int b, String method, Random random) {

        return -1.0;
    }

    // Implementieren Sie hier Ihre Lösung für das Aufteilen des Arrays
    public int split(Point[] points, int a, int b, double pivot) {
        
        return -1;
    }


    // Implementieren Sie hier Ihre Lösung für die Kombination zweier Teilprobleme
    public PointPair combination(Point[] points, int a, int b, double delta, int t, double L) {
        
        return null;
    }

}
