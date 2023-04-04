package main.java.exercise;

import main.java.framework.StudentInformation;
import main.java.framework.StudentSolution;

public class StudentSolutionImplementation implements StudentSolution {
    @Override
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "", // Vorname
                "", // Nachname
                "" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für die Maximumsuche
    public int findMax(int[] numbers) {

        return 0;
    }

    // Implementieren Sie hier Ihre Lösung für das dichteste Punktepaar
    public void findClosestPair(Point[] points, ClosestPair closestPair) {

    }

    // Implementieren Sie hier Ihre Lösung für die Teilsummen
    public boolean hasSubsetSum(int sum, int[] numbers) {

        return false;
    }

}
