package main.java.exercise;

import main.java.framework.InstanceSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstanceSetImplementation extends InstanceSet<InstanceImplementation, StudentSolutionImplementation, ResultImplementation, VerifierImplementation, Point[]> {

    public InstanceSetImplementation(Path instanceSetPath, Path outputPath) {
        super(instanceSetPath, outputPath, ResultImplementation.class);
    }

    @Override
    protected InstanceImplementation instanceFromCsv(String line) {
        String[] splitLine = line.split(",", -1);
        int number = Integer.parseInt(splitLine[0]);
        String groupName = splitLine[1];
        String dataset = splitLine[2];
        int size = Integer.parseInt(splitLine[3]);

        if (groupName.equals("Insertion Sort")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            boolean sortX = Boolean.parseBoolean(splitLine[6]);

            return new InstanceImplementation(number, groupName, dataset, size, sortX, null, pointsOriginal,
                    points, a, b, null, -1, -1, null, -1, -1, -1);
        } else if (groupName.equals("Brute Force")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            Point point1 = new Point(Double.parseDouble(splitLine[6]), Double.parseDouble(splitLine[7]));
            Point point2 = new Point(Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[9]));
            PointPair pointPair = new PointPair(point1, point2);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            double dist;
            if (splitLine[10].equals("Inf")) {
                dist = Double.POSITIVE_INFINITY;
            }
            else {
                dist = Double.parseDouble(splitLine[10]);
            }

            return new InstanceImplementation(number, groupName, dataset, size, false, null, pointsOriginal,
                    points, a, b, pointPair, dist, -1, null, -1, -1, -1);
        } else if (groupName.equals("Random")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            String method = "Random";
            groupName = "SplitValue - Random";

            return new InstanceImplementation(number, groupName, dataset, size, false, method, pointsOriginal,
                    points, a, b, null, -1, -1, null, -1, -1, -1);

        } else if (groupName.equals("First") || groupName.equals("Median Of Three") || groupName.equals("Mean")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            String method = groupName;
            groupName = "SplitValue - " + method;

            double splitValue = Double.parseDouble(splitLine[6]);

            return new InstanceImplementation(number, groupName, dataset, size, false, method, pointsOriginal,
                    points, a, b, null, -1, splitValue, null, -1, -1, -1);
        } else if (groupName.equals("Split")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            double value = Double.parseDouble(splitLine[6]);

            String[] splits = splitLine[7].split(":", -1);
            HashSet<Integer> splitSet = new HashSet<Integer>();
            for (String s : splits) {
                splitSet.add(Integer.parseInt(s));
            }

            return new InstanceImplementation(number, groupName, dataset, size, false,null, pointsOriginal,
                    points, a, b, null, -1, value, splitSet, -1, -1, -1);
        } else if (groupName.equals("Combination")) {
            int a = Integer.parseInt(splitLine[4]);
            int b = Integer.parseInt(splitLine[5]);

            double delta = Double.parseDouble(splitLine[6]);
            int t = Integer.parseInt(splitLine[7]);
            HashSet<Integer> tset = new HashSet<>();
            tset.add(t);

            double L = Double.parseDouble(splitLine[8]);

            int abar = Integer.parseInt(splitLine[9]);
            int bbar = Integer.parseInt(splitLine[10]);

            Point point1 = new Point(Double.parseDouble(splitLine[11]), Double.parseDouble(splitLine[12]));
            Point point2 = new Point(Double.parseDouble(splitLine[13]), Double.parseDouble(splitLine[14]));
            PointPair pointPair = new PointPair(point1, point2);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            double dist;
            if (splitLine[15].equals("Inf")) {
                dist = Double.POSITIVE_INFINITY;
            }
            else {
                dist = Double.parseDouble(splitLine[15]);
            }

            return new InstanceImplementation(number, groupName, dataset, size, false, null, pointsOriginal,
                    points, a, b, pointPair, dist, L, tset, delta, abar, bbar);
        } else if (groupName.equals("Closest Pair")) {

            String method = splitLine[4];

            Point point1 = new Point(Double.parseDouble(splitLine[5]), Double.parseDouble(splitLine[6]));
            Point point2 = new Point(Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]));
            PointPair pointPair = new PointPair(point1, point2);

            Point[] pointsFull = this.getAdditionalInput(dataset + ".txt");
            Point[] pointsOriginal = new Point[size];
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = new Point(pointsFull[i]);
                pointsOriginal[i] = new Point(pointsFull[i]);
            }

            double dist = Double.parseDouble(splitLine[9]);

            groupName = groupName + ": " + dataset + " - " + method;

            return new InstanceImplementation(number, groupName, dataset, size, false, method, pointsOriginal,
                    points, 0, size, pointPair, dist, -1, null, -1, -1, -1);
        }

        return null;
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
    protected Point[] parseAdditionalInput(BufferedReader reader) {
        List<Point> pointList = new ArrayList<Point>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",", -1);
                double x = Double.parseDouble(splitLine[0]);
                double y = Double.parseDouble(splitLine[1]);
                pointList.add(new Point(x, y));
            }
        } catch (IOException e) {
            return new Point[0];
        }
        return pointList.toArray(new Point[pointList.size()]);
    }
}
