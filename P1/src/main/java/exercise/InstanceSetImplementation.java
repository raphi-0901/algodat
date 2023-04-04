package main.java.exercise;

import main.java.framework.InstanceSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InstanceSetImplementation extends InstanceSet<InstanceImplementation, StudentSolutionImplementation, ResultImplementation, VerifierImplementation, Integer[]> {

    public InstanceSetImplementation(Path instanceSetPath, Path outputPath) {
        super(instanceSetPath, outputPath, ResultImplementation.class);
    }

    @Override
    protected InstanceImplementation instanceFromCsv(String line) {
        String[] splitLine = line.split(",", 5);
        String problemType = splitLine[1];
        if (problemType.equals("Maximumsuche")) {
            Integer[] numbers = this.getAdditionalInput("numbers.txt");
            int size = Integer.parseInt(splitLine[2]);
            int[] castNumbers = new int[size];
            for (int i = 0; i < size; i++) {
                castNumbers[i] = numbers[i];
            }
            return new InstanceImplementation(splitLine[1], Integer.parseInt(splitLine[0]), castNumbers, null, 0, Integer.parseInt(splitLine[3]), null, false);
        } else if (problemType.equals("Dichtestes Punktepaar")) {
            Integer[] numbers = this.getAdditionalInput("numbers.txt");
            int size = Integer.parseInt(splitLine[2]);
            Point[] castPoints = new Point[size];
            for (int i = 0; i < size; i++) {
                Integer[] coordinates = new Integer[2];
                coordinates[0] = numbers[i * 2];
                coordinates[1] = numbers[i * 2 + 1];
                Point point = new Point(coordinates);
                castPoints[i] = point;
            }
            Point point1 = new Point(splitLine[3]);
            Point point2 = new Point(splitLine[4]);
            return new InstanceImplementation(splitLine[1], Integer.parseInt(splitLine[0]), null, castPoints, 0, 0, new ClosestPair(point1, point2), false);
        } else {
            String[] numbers = splitLine[4].split(",");
            int[] castNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                int number = Integer.parseInt(numbers[i]);
                castNumbers[i] = number;
            }
            return new InstanceImplementation(splitLine[1], Integer.parseInt(splitLine[0]), castNumbers, null, Integer.parseInt(splitLine[3]), 0, null, splitLine[2].equals("true"));
        }
    }

    @Override
    protected StudentSolutionImplementation provideStudentSolution() {
        return new StudentSolutionImplementation();
    }

    @Override
    protected VerifierImplementation provideVerifier() {
        return new VerifierImplementation();
    }

    @Override
    protected Integer[] parseAdditionalInput(BufferedReader reader) {
        List<Integer> numbers = new ArrayList<Integer>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            return new Integer[0];
        }
        return numbers.toArray(new Integer[numbers.size()]);
    }
}
