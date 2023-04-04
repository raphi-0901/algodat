package main.java.exercise;

import main.java.framework.StudentInformation;
import main.java.framework.StudentSolution;

public class StudentSolutionImplementation implements StudentSolution {
    @Override
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "Raphael", // Vorname
                "Wirnsberger", // Nachname
                "12220836" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für die Maximumsuche
    public int findMax(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    // Implementieren Sie hier Ihre Lösung für das dichteste Punktepaar
    public void findClosestPair(Point[] points, ClosestPair closestPair) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point point2 = points[j];
                int delta = (int) (Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
                if (min > delta) {
                    min = delta;
                    closestPair.setPoint1(point1);
                    closestPair.setPoint2(point2);
                }
            }
        }
    }

    // Implementieren Sie hier Ihre Lösung für die Teilsummen
    public boolean hasSubsetSum(int sum, int[] numbers) {
//        numbers = new int[]{4, 5, 2, 7};
//        sum = 9;

        boolean[][] lookUpTable = new boolean[numbers.length+1][sum+1];

        // Der Fall "sum = 0" ist immer wahr
        for (int i = 0; i <= numbers.length; i++) {
            lookUpTable[i][0] = true;
        }

        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(numbers[i - 1] > j) {
                    lookUpTable[i][j] = lookUpTable[i-1][j];
                    continue;
                }

                // entweder man übernimmt den Wert von der Zeile darüber oder man schaut ob der Wert um numbers[i-1] auf true gesetzt ist
                lookUpTable[i][j] = lookUpTable[i-1][j] || lookUpTable[i-1][j-numbers[i - 1]];
            }
        }
        return lookUpTable[numbers.length][sum];
    }
}
