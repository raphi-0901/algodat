package main.java.exercise;

import main.java.framework.Report;
import main.java.framework.Timer;
import main.java.framework.Verifier;
import java.util.Random;

public class VerifierImplementation extends Verifier<InstanceImplementation, StudentSolutionImplementation, ResultImplementation> {

    Random random = new Random();

    @Override
    public ResultImplementation solveProblemUsingStudentSolution(InstanceImplementation instance,
                                                                 StudentSolutionImplementation studentSolution) {

        if (instance.getGroupName().equals("Insertion Sort")) {
            Timer timer = new Timer();
            timer.start();
            studentSolution.insertionSort(instance.getPoints(), instance.getA(), instance.getB(), instance.isSortX());
            timer.stop();

            boolean isSortedXInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedXOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedX = isSortedXInside && isSortedXOutside;
            boolean isSortedYInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedYOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedY = isSortedYInside && isSortedYOutside;

            boolean fixedNumbersInside = fixedNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbers = fixedNumbersInside && fixedNumbersOutside;

            boolean keptNumbersInside = keptNumbersInside(instance.getPoints(), instance.getPointsOriginal(), instance.getA(), instance.getB());
            boolean keptNumbersOutside = keptNumbersOutside(instance.getPoints(), instance.getPointsOriginal(), instance.getA(), instance.getB());


            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = noDuplicates(instance.getPoints());

            boolean splitLeft = false;          // egal
            boolean splitRight = false;         // egal

            double bestDist = -1;               // egal
            PointPair closestPair = null;       // egal
            boolean isPointPairFeasible = false;// egal
            boolean isClosestPair = false;      // egal
            boolean isPointNotIdentical = false;// egal
            boolean distCorrect = false;        // egal

            boolean splitValueValid = false;    // egal
            double splitValue = -1;             // egal
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);

        } else if (instance.getGroupName().equals("Brute Force")) {
            Timer timer = new Timer();
            timer.start();
            PointPair res = studentSolution.bruteForce(instance.getPoints(), instance.getA(), instance.getB());
            timer.stop();

            boolean isSortedXInside = false;     // egal
            boolean isSortedXOutside = false;    // egal
            boolean isSortedX = false;           // egal
            boolean isSortedYInside = false;     // egal
            boolean isSortedYOutside = false;    // egal
            boolean isSortedY = false;           // egal

            boolean fixedNumbersInside = fixedNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbers = fixedNumbersInside && fixedNumbersOutside;

            boolean keptNumbersInside = false;  // egal
            boolean keptNumbersOutside = false; // egal

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = false;       // egal

            boolean splitLeft = false;          // egal
            boolean splitRight = false;         // egal

            double bestDist;
            PointPair closestPair;
            boolean isPointPairFeasible;
            boolean isClosestPair;
            boolean isPointNotIdentical;
            boolean distCorrect;
            if (res != null) {
                bestDist = res.getDistance();
                closestPair = res;
                isPointPairFeasible = isPointPairFeasible(closestPair, instance.getPointsOriginal());
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = isPointNotIdentical(res);
                distCorrect = distCorrect(res);
            }
            else {
                bestDist = Double.POSITIVE_INFINITY;
                closestPair = res;
                isPointPairFeasible = true;  // egal bei null
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = true;  // egal bei null
                distCorrect = true;     // egal bei null!
            }


            boolean splitValueValid = false;    // egal
            double splitValue = -1;             // egal
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);

        } else if (instance.getGroupName().equals("SplitValue - Random")) {
            Timer timer = new Timer();
            timer.start();
            double res = studentSolution.getPivotValue(instance.getPoints(), instance.getA(), instance.getB(), instance.getMethod(), random);
            timer.stop();

            boolean isSortedXInside = false;     // egal
            boolean isSortedXOutside = false;    // egal
            boolean isSortedX = false;           // egal
            boolean isSortedYInside = false;     // egal
            boolean isSortedYOutside = false;    // egal
            boolean isSortedY = false;           // egal

            boolean fixedNumbersInside = fixedNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbers = fixedNumbersInside && fixedNumbersOutside;

            boolean keptNumbersInside = false;  // egal
            boolean keptNumbersOutside = false; // egal

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = false;       // egal

            boolean splitLeft = false;          // egal
            boolean splitRight = false;         // egal

            double bestDist = -1;               // egal
            PointPair closestPair = null;       // egal
            boolean isPointPairFeasible = false;    // egal
            boolean isClosestPair = false;      // egal
            boolean isPointNotIdentical = false;// egal
            boolean distCorrect = false;        // egal

            boolean splitValueValid = splitValueValid(res, instance.getPointsOriginal(), instance.getA(), instance.getB());
            double splitValue = res;
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);

        } else if (instance.getGroupName().equals("SplitValue - First") || instance.getGroupName().equals("SplitValue - Median Of Three") || instance.getGroupName().equals("SplitValue - Mean")) {
            Timer timer = new Timer();
            timer.start();
            double res = studentSolution.getPivotValue(instance.getPoints(), instance.getA(), instance.getB(), instance.getMethod(), random);
            timer.stop();

            boolean isSortedXInside = false;     // egal
            boolean isSortedXOutside = false;    // egal
            boolean isSortedX = false;           // egal
            boolean isSortedYInside = false;     // egal
            boolean isSortedYOutside = false;    // egal
            boolean isSortedY = false;           // egal

            boolean fixedNumbersInside = fixedNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbers = fixedNumbersInside && fixedNumbersOutside;

            boolean keptNumbersInside = false;  // egal
            boolean keptNumbersOutside = false; // egal

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = false;       // egal

            boolean splitLeft = false;          // egal
            boolean splitRight = false;         // egal

            double bestDist = -1;               // egal
            PointPair closestPair = null;       // egal
            boolean isPointPairFeasible = false;    // egal
            boolean isClosestPair = false;      // egal
            boolean isPointNotIdentical = false;// egal
            boolean distCorrect = false;        // egal

            boolean splitValueValid;
            if (instance.getGroupName().equals("SplitValue - Mean")) {
                res = Math.round(res * 10000) / 10000.;
                splitValueValid = Math.abs(res - instance.getSplitValue()) < 0.0001;
            }
            else {
                splitValueValid = res == instance.getSplitValue();
            }
            double splitValue = res;
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);

        } else if (instance.getGroupName().equals("Split")) {
            Timer timer = new Timer();
            timer.start();
            int res = studentSolution.split(instance.getPoints(), instance.getA(), instance.getB(), instance.getSplitValue());
            timer.stop();

            boolean isSortedXInside = false;     // egal
            boolean isSortedXOutside = false;    // egal
            boolean isSortedX = false;           // egal
            boolean isSortedYInside = false;     // egal
            boolean isSortedYOutside = false;    // egal
            boolean isSortedY = false;           // egal

            boolean fixedNumbersInside = fixedNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean fixedNumbers = fixedNumbersInside && fixedNumbersOutside;

            boolean keptNumbersInside = keptNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean keptNumbersOutside = keptNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = noDuplicates(instance.getPoints());

            boolean splitLeft = splitLeft(instance.getPoints(), res, instance.getSplitValue(), instance.getA(), instance.getB());
            boolean splitRight = splitRight(instance.getPoints(), res, instance.getSplitValue(), instance.getA(), instance.getB());

            double bestDist = -1;                  // egal
            PointPair closestPair = null;          // egal
            boolean isPointPairFeasible = false;   // egal
            boolean isClosestPair = false;         // egal
            boolean isPointNotIdentical = false;   // egal
            boolean distCorrect = false;           // egal

            boolean splitValueValid = false;       // egal
            double splitValue = -1;                // egal
            int splitPoint = res;

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);

        } else if (instance.getGroupName().equals("Combination")) {
            Integer[] temp = instance.getSplitIndex().toArray(new Integer[instance.getSplitIndex().size()]);

            Timer timer = new Timer();
            timer.start();
            PointPair res = studentSolution.combination(instance.getPoints(), instance.getA(), instance.getB(),
                    instance.getDelta(), temp[0], instance.getSplitValue());
            timer.stop();

            boolean isSortedXInside = false;       // egal
            boolean isSortedXOutside = false;      // egal
            boolean isSortedX = isSortedXInside && isSortedXOutside;
            boolean isSortedYInside = isSortedInside(instance.getPoints(), instance.getAbar(), instance.getBbar(), false);
            boolean isSortedYOutside = isSortedOutside(instance.getPoints(), instance.getAbar(), instance.getBbar(), false);
            boolean isSortedY = isSortedYInside && isSortedYOutside;

            boolean fixedNumbersInside = false;    // egal
            boolean fixedNumbersOutside = fixedNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getAbar(), instance.getBbar());
            boolean fixedNumbers = false;          // egal

            boolean keptNumbersInside = keptNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getAbar(), instance.getBbar());
            boolean keptNumbersOutside = false;    // egal

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = noDuplicates(instance.getPoints());

            boolean splitLeft = false;             // egal
            boolean splitRight = false;            // egal

            double bestDist;
            PointPair closestPair;
            boolean isPointPairFeasible;
            boolean isClosestPair;
            boolean isPointNotIdentical;
            boolean distCorrect;
            if (res != null) {
                bestDist = res.getDistance();
                closestPair = res;
                isPointPairFeasible = isPointPairFeasible(closestPair, instance.getPointsOriginal());
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = isPointNotIdentical(res);
                distCorrect = distCorrect(res);
            }
            else {
                bestDist = Double.POSITIVE_INFINITY;
                closestPair = res;
                isPointPairFeasible = true;  // egal bei null
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = true;  // egal bei null
                distCorrect = true;     // egal bei null!
            }

            boolean splitValueValid = false;    // egal
            double splitValue = -1;             // egal
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);
        } else if (instance.getGroupName().contains("Closest Pair") && instance.getGroupName().contains("Brute Force")) {
            Timer timer = new Timer();
            timer.start();
            PointPair res = studentSolution.bruteForce(instance.getPoints(), instance.getA(), instance.getB());
            timer.stop();

            boolean isSortedXInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedXOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedX = isSortedXInside && isSortedXOutside;
            boolean isSortedYInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedYOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedY = isSortedYInside && isSortedYOutside;

            boolean fixedNumbersInside = false;    // egal
            boolean fixedNumbersOutside = false;   // egal
            boolean fixedNumbers = false;          // egal

            boolean keptNumbersInside = keptNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean keptNumbersOutside = keptNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = noDuplicates(instance.getPoints());

            boolean splitLeft = false;             // egal
            boolean splitRight = false;            // egal

            double bestDist;
            PointPair closestPair;
            boolean isPointPairFeasible;
            boolean isClosestPair;
            boolean isPointNotIdentical;
            boolean distCorrect;
            if (res != null) {
                bestDist = res.getDistance();
                closestPair = res;
                isPointPairFeasible = isPointPairFeasible(closestPair, instance.getPointsOriginal());
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = isPointNotIdentical(res);
                distCorrect = distCorrect(res);
            }
            else {
                bestDist = Double.POSITIVE_INFINITY;
                closestPair = res;
                isPointPairFeasible = true;  // egal bei null
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = true;  // egal bei null
                distCorrect = true;     // egal bei null!
            }

            boolean splitValueValid = false;    // egal
            double splitValue = -1;             // egal
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);
        } else if (instance.getGroupName().contains("Closest Pair")) {
            Timer timer = new Timer();
            PointPair res;
            timer.start();
            try {
                res = closestPair(instance.getPoints(), instance.getA(), instance.getB(), Double.POSITIVE_INFINITY, instance.getMethod(), random, studentSolution);
            }
            catch (StackOverflowError e) {
                System.out.println("Warning: Switch to Brute Force due to Stack Overflow Error. ");
                res = studentSolution.bruteForce(instance.getPoints(), instance.getA(), instance.getB());
            }
            timer.stop();

            boolean isSortedXInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedXOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), true);
            boolean isSortedX = isSortedXInside && isSortedXOutside;
            boolean isSortedYInside = isSortedInside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedYOutside = isSortedOutside(instance.getPoints(), instance.getA(), instance.getB(), false);
            boolean isSortedY = isSortedYInside && isSortedYOutside;

            boolean fixedNumbersInside = false;    // egal
            boolean fixedNumbersOutside = false;   // egal
            boolean fixedNumbers = false;          // egal

            boolean keptNumbersInside = keptNumbersInside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());
            boolean keptNumbersOutside = keptNumbersOutside(instance.getPoints(), instance.getPointsOriginal(),
                    instance.getA(), instance.getB());

            boolean keptNumbers = keptNumbersInside && keptNumbersOutside;
            boolean noDuplicates = noDuplicates(instance.getPoints());

            boolean splitLeft = false;             // egal
            boolean splitRight = false;            // egal

            double bestDist;
            PointPair closestPair;
            boolean isPointPairFeasible;
            boolean isClosestPair;
            boolean isPointNotIdentical;
            boolean distCorrect;
            if (res != null) {
                bestDist = res.getDistance();
                closestPair = res;
                isPointPairFeasible = isPointPairFeasible(closestPair, instance.getPointsOriginal());
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = isPointNotIdentical(res);
                distCorrect = distCorrect(res);
            }
            else {
                bestDist = Double.POSITIVE_INFINITY;
                closestPair = res;
                isPointPairFeasible = true;  // egal bei null
                isClosestPair = isClosestPair(closestPair, instance.getClosestPointPair());
                isPointNotIdentical = true;  // egal bei null
                distCorrect = true;     // egal bei null!
            }

            boolean splitValueValid = false;    // egal
            double splitValue = -1;             // egal
            int splitPoint = -1;                // egal

            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getSize(),
                    isSortedXInside, isSortedXOutside, isSortedX, isSortedYInside, isSortedYOutside, isSortedY,
                    fixedNumbersInside, fixedNumbersOutside, fixedNumbers,
                    keptNumbersInside, keptNumbersOutside,
                    keptNumbers, noDuplicates,  splitLeft, splitRight, bestDist, closestPair, isPointPairFeasible, isClosestPair, isPointNotIdentical, distCorrect,
                    splitValueValid, splitValue, splitPoint);
        }

        return null;
    }


    // Prüft, ob die Zahlen in [a, b) sortiert sind.
    private boolean isSortedInside(Point[] points, int a, int b, boolean sortX) {
        if (sortX) {
            for (int i = a + 1; i < b; i++) {
                if (points[i].getX() < points[i-1].getX()) {
                    return false;
                }
            }
        }
        else {
            for (int i = a + 1; i < b; i++) {
                if (points[i].getY() < points[i-1].getY()) {
                    return false;
                }
            }
        }

        return true;
    }

    // Prüft, ob die Zahlen außerhalb von [a, b) sortiert sind.
    private boolean isSortedOutside(Point[] points, int a, int b, boolean sortX) {
        return isSortedInside(points, 0, a, sortX) && isSortedInside(points, b, points.length, sortX);
    }


    // Prüft, ob in [a, b) die Punkte ident sind. Falls leer, immer true.
    private boolean fixedNumbersInside(Point[] points, Point[] pointsOriginal, int a, int b) {
        if (b - a == 0) {
            return true;
        }
        for (int i = a; i < b; i++) {
            if (!points[i].equals(pointsOriginal[i])) {
                return false;
            }
        }
        return true;
    }

    // Prüft, ob außerhalb von [a, b) die Punkte ident sind.
    private boolean fixedNumbersOutside(Point[] points, Point[] pointsOriginal, int a, int b) {
        return fixedNumbersInside(points, pointsOriginal, 0, a) && fixedNumbersInside(points, pointsOriginal, b, pointsOriginal.length);
    }

    // Prüft, ob der gefundene Punkt ein closest Pair ist.
    private boolean isClosestPair(PointPair closestPairRes, PointPair closestPairInstance) {
        if (closestPairRes == null && closestPairInstance == null) {
            return true;
        }
        if (closestPairRes != null && closestPairInstance == null) {
            return false;
        }
        if (closestPairRes == null && closestPairInstance != null) {
            return false;
        }

        if (closestPairRes.equals(closestPairInstance)) {
            return true;
        }

        // Abweichung: Prüfe, ob das vorgeschlagene Punktpaar gleich gut ist (ohne Prüfung auf Gültigkeit)
        double distRes = closestPairRes.getDistance();
        double distInst = closestPairInstance.getDistance();
        if (Math.abs(distRes - distInst) <= 0.0001) {
            return true;
        }

        return false;
    }

    private boolean distCorrect(PointPair pointPair) {
        Point p1 = pointPair.getPoint1();
        Point p2 = pointPair.getPoint2();
        double dist = p1.getDistance(p2);

        // Rundungsfehler beachten
        return (Math.abs(pointPair.getDistance() - dist) <= 0.0001);
    }

    // Prüft, ob Punktpaar in points vorkommt.
    private boolean isPointPairFeasible(PointPair pointPair, Point[] pointsOriginal) {
        boolean bool1 = false;
        boolean bool2 = false;
        for (int i = 0; i < pointsOriginal.length; i++) {
            if (pointPair.getPoint1().equals(pointsOriginal[i])) {
                bool1 = true;
            }
            if (pointPair.getPoint2().equals(pointsOriginal[i])) {
                bool2 = true;
            }
        }

        return bool1 && bool2;
    }


    // Prüft, ob der vorgeschlagene splitValue in points in [a, b) vorkommt.
    private boolean splitValueValid(double splitValue, Point[] points, int a, int b) {
        for (int i = a; i < b; i++) {
            if (points[i].getX() == splitValue) {
                return true;
            }
        }

        return false;
    }


    // Prüft, ob die Zahlen innerhalb von [a, b) gehalten wurden (bis auf Positionsausch)
    private boolean keptNumbersInside(Point[] points, Point[] pointsOriginal, int a, int b) {
        for (int i = a; i < b; i++) {
            boolean res = false;
            for (int j = a; j < b; j++) {
                if (points[i].equals(pointsOriginal[j])) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                return false;
            }
        }
        return true;
    }

    // Prüft, ob die Zahlen außerhalb von [a, b) gehalten wurden (bis auf Positionsausch)
    private boolean keptNumbersOutside(Point[] points, Point[] pointsOriginal, int a, int b) {
        for (int i = 0; i < points.length; i++) {
            if (i < a || i >= b) {
                continue;
            }
            boolean res = false;
            for (int j = 0; j < points.length; j++) {
                if (j < a || j >= b) {
                    continue;
                }
                if (points[i].equals(pointsOriginal[j])) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                return false;
            }
        }
        return true;
    }


    // Prüft, ob points keine Duplikate hat
    private boolean noDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return false;
                }
            }
        }
        return true;
    }


    // Prüft, ob im Bereich [a, splitPoint) alle Elemente <= splitValue sind
    private boolean splitLeft(Point[] points, int splitPoint, double splitValue, int a, int b) {
        if (splitPoint == -1) return true;

        for (int i = a; i < splitPoint; i++) {
            if (points[i].getX() > splitValue) {
                return false;
            }
        }
        return true;
    }

    // Prüft, ob im Bereich [splitPoint, b) alle Elemente >= splitValue sind
    private boolean splitRight(Point[] points, int splitPoint, double splitValue, int a, int b) {
        if (splitPoint == -1) return true;

        for (int i = splitPoint; i < b; i++) {
            if (points[i].getX() < splitValue) {
                return false;
            }
        }
        return true;
    }


    private boolean isPointNotIdentical(PointPair pair) {
        return !pair.getPoint1().equals(pair.getPoint2());
    }







    @Override
    public Report verifyResult(InstanceImplementation instance, ResultImplementation result) {
        boolean correct = true;
        String fehlertext = "Error in instance " + instance.getNumber() + " (size = " + instance.getSize();
        fehlertext += ", a = " + instance.getA() + ", b = " + instance.getB() + "):\n";

        if (instance.getGroupName().equals("Insertion Sort")) {
            if (instance.isSortX() && !result.isSortedXInside()) {
                fehlertext += "The points are not sorted according to their x values within the interval [a, b). ";
                correct = false;
            }
            if (!instance.isSortX() && !result.isSortedYInside()) {
                fehlertext += "The points are not sorted according to their y values within the interval [a, b). ";
                correct = false;
            }
            if (!result.isKeptNumbersInside()) {
                fehlertext += "The points within the interval [a, b) are not the same after applying the insertion sort method. ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a, b) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isNoDuplicates()) {
                fehlertext += "Duplicated points occur in your solution (all points are unique in the datasets). Please check if you swap elements correctly. ";
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        }
        if (instance.getGroupName().equals("Brute Force")) {
            if (!result.isFixedNumbersInside()) {
                fehlertext += "The points within the interval [a, b) did change. Pay attention, that the points in this interval keep the same. ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a, b) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isDistCorrect()) {
                fehlertext += "The distance is not correctly determined. The distance between the points " + result.getClosestPair() + " was " + result.getBestDist() + " but should be " + result.getClosestPair().computeDistance() + ". ";
                correct = false;
            }
            if (!result.isPointPairFeasible()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " is not a feasible solution. At least one point is not contained in the array 'points'. ";
                correct = false;
            }
            if (!result.isPairNotIdentical()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " has identical points which is infeasible. Maybe you should check your variables in your loops. ";
            }
            if (!result.isClosestPair()) {
                if (result.getClosestPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your result is null but there is a feasible solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                } else if (instance.getClosestPointPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair is " + result.getClosestPair() + " but null is the correct answer. ";
                } else {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair " + result.getClosestPair() + " has a distance of " + result.getBestDist() + " but there is a solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                }
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        } else if (instance.getGroupName().equals("SplitValue - Random")) {
            if (!result.isFixedNumbersInside()) {
                fehlertext += "The points within the interval [a, b) did change. Pay attention, that the points in this interval keep the same. ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a, b) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isSplitValueValid() && (instance.getB() - instance.getA() > 1)) {
                fehlertext += "Your suggested pivot value of " + result.getSplitValue() + " is not a valid x-value of a point in the interval [a, b). ";
                correct = false;
            }
            if (instance.getB() - instance.getA() <= 1 && result.getSplitValue() != -1) {
                fehlertext += "Your suggested pivot value of " + result.getSplitValue() + " is not right. The expected result is -1. Maybe check if the interval [a, b) is large enough. ";
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        } else if (instance.getGroupName().equals("SplitValue - First") || instance.getGroupName().equals("SplitValue - Median Of Three") || instance.getGroupName().equals("SplitValue - Mean")) {
            if (!result.isFixedNumbersInside()) {
                fehlertext += "The points within the interval [a, b) did change. Pay attention, that the points in this interval keep the same. ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a, b) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isSplitValueValid() && instance.getGroupName().contains("First")) {
                fehlertext += "Your suggested pivot value of " + result.getSplitValue() + " is not right. The expected result is " + instance.getSplitValue() + ". Maybe check if you chose the right index. ";
                if (instance.getB() - instance.getA() <= 1) {
                    fehlertext += "Maybe check if the interval [a, b) is large enough. ";
                }
                correct = false;
            }
            if (!result.isSplitValueValid() && instance.getGroupName().contains("Median Of Three")) {
                fehlertext += "Your suggested pivot value of " + result.getSplitValue() + " is not right. The expected result is " + instance.getSplitValue() + ". Maybe check if you chose the right indices. ";
                if (instance.getB() - instance.getA() <= 1) {
                    fehlertext += "Maybe check if the interval [a, b) is large enough. ";
                }
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        } else if (instance.getGroupName().equals("Split")) {
            if (!result.isKeptNumbersInside()) {
                fehlertext += "The points within the interval [a, b) are not the same after applying the split method. ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a, b) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isNoDuplicates()) {
                fehlertext += "Duplicated points occur in your solution (all points are unique in the datasets). Please check if you swap elements correctly. ";
                correct = false;
            }
            if (!instance.getSplitIndex().contains(result.getSplitPoint())) {
                String right = instance.getSplitIndexString();
                fehlertext += "The computed split index is not correct. Your answer was " + result.getSplitPoint() + " but the right answer is any index in the set " + right + ". ";

                correct = false;
            }
            if (!result.isSplitLeft()) {
                fehlertext += "Not all points in the interval [a, t) have an x-value smaller or equal than the given pivot value " + instance.getSplitValue() + ". ";
                correct = false;
            }
            if (!result.isSplitRight()) {
                fehlertext += "Not all points in the interval [t, b) have an x-value greater than the given pivot value " + instance.getSplitValue() + ". ";
                correct = false;
            }


            if (correct) {
                return new Report(true, "");
            } else {
                return new Report(false, fehlertext);
            }
        } else if (instance.getGroupName().equals("Combination")) {
            if (!instance.isSortX() && !result.isSortedYInside()) {
                int abar = instance.getAbar();
                int bbar = instance.getBbar();

                fehlertext += "The points are not sorted according to their y values within the interval [a_bar, b_bar). ";
                fehlertext += "The expected interval [a_bar, b_bar) = [" + abar + ", " + bbar + "). ";
                fehlertext += "Please check if you computed this interval correctly and/or if the values within this interval are sorted with respect to their y-coordinates. ";
                correct = false;
            }
            if (!result.isKeptNumbersInside()) {
                fehlertext += "The points within the interval [a_bar, b_bar) are not the same after applying the combination method. ";
                fehlertext += "Pay attention, that you do not include points outside of [a_bar, b_bar). ";
                correct = false;
            }
            if (!result.isFixedNumbersOutside()) {
                fehlertext += "The points outside the interval [a_bar, b_bar) did change. Pay attention, that the points outside this interval keep the same. ";
                correct = false;
            }
            if (!result.isNoDuplicates()) {
                fehlertext += "Duplicated points occur in your solution (all points are unique in the datasets). Please check if you swap elements correctly. ";
                correct = false;
            }
            if (!result.isDistCorrect()) {
                fehlertext += "The distance is not correctly determined. The distance between the points " + result.getClosestPair() + " was " + result.getBestDist() + " but should be " + result.getClosestPair().computeDistance() + ". ";
                correct = false;
            }
            if (!result.isPointPairFeasible()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " is not a feasible solution. ";
                correct = false;
            }
            if (!result.isPairNotIdentical()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " has identical points which is infeasible. Maybe you should check your loops. ";
            }
            if (!result.isClosestPair()) {
                if (result.getClosestPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your result is null but there is a feasible solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                } else if (instance.getClosestPointPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair is " + result.getClosestPair() + " but null is the correct answer. ";
                } else {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair " + result.getClosestPair() + " has a distance of " + result.getBestDist() + " but there is a solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                }
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        } else if (instance.getGroupName().contains("Closest Pair")) {
            if (!result.isDistCorrect()) {
                fehlertext += "The distance is not correctly determined. The distance between the points " + result.getClosestPair() + " was " + result.getBestDist() + " but should be " + result.getClosestPair().computeDistance() + ". ";
                correct = false;
            }
            if (!result.isPointPairFeasible()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " is not a feasible solution. ";
                correct = false;
            }
            if (!result.isPairNotIdentical()) {
                fehlertext += "Your point pair " + result.getClosestPair() + " has identical points which is infeasible. Maybe you should check your loops. ";
            }
            if (!result.isClosestPair()) {
                if (result.getClosestPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your result is null but there is a feasible solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                } else if (instance.getClosestPointPair() == null) {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair is " + result.getClosestPair() + " but null is the correct answer. ";
                } else {
                    fehlertext += "The solution is not a closest pair. Your suggestion for the closest point pair " + result.getClosestPair() + " has a distance of " + result.getBestDist() + " but there is a solution (e.g. " + instance.getClosestPointPair().toString() + ") with a distance of " + instance.getBestDist() + ". ";
                }
                correct = false;
            }
            if (!result.isNoDuplicates()) {
                fehlertext += "Duplicated points occur in your solution (all points are unique in the datasets). Please check if you swap elements correctly. ";
                correct = false;
            }
            if (!result.isKeptNumbers()) {
                fehlertext += "Pay attention, that you do not include points outside of [a, b) during the application of the split method. ";
                correct = false;
            }

            if (correct) {
                return new Report(true, "");
            }
            else {
                return new Report(false, fehlertext);
            }
        }

        return null;
    }



    public PointPair closestPair(Point[] points, int a, int b, double bestSoFar, String pivotMethod, Random random,
                                 StudentSolutionImplementation ssi) {
        if (b - a <= 3) {
            // Löse Teilproblem direkt
            ssi.insertionSort(points, a, b, true);
            return ssi.bruteForce(points, a, b);
        }

        // Zerlege das Problem in zwei Teilprobleme
        double L = ssi.getPivotValue(points, a, b, pivotMethod, random);
        int t = ssi.split(points, a, b, L);

        PointPair res = null;

        // Linkes Teilproblem lösen
        PointPair links = closestPair(points, a, t, bestSoFar, pivotMethod, random, ssi);
        if (links != null && links.getDistance() < bestSoFar) {
            bestSoFar = links.getDistance();
        }
        if (links != null && (res == null || links.getDistance() < res.getDistance())) {
            res = links;
        }

        // Rechtes Teilproblem lösen
        PointPair rechts = closestPair(points, t, b, bestSoFar, pivotMethod, random, ssi);
        if (rechts != null && rechts.getDistance() < bestSoFar) {
            bestSoFar = rechts.getDistance();
        }
        if (rechts != null && (res == null || rechts.getDistance() < res.getDistance())) {
            res = rechts;
        }

        // Kombiniere

        // Stand sichern
        Point[] copy = new Point[b - a];
        for (int i = 0; i < b - a; i++) {
            copy[i] = points[i + a];
        }

        PointPair mitte = ssi.combination(points, a, b, bestSoFar, t, L);
        if (mitte != null && (res == null || mitte.getDistance() < res.getDistance())) {
            res = mitte;
        }

        // Punkte zurücksetzen
        for (int i = 0; i < b - a; i++) {
            points[i + a] = copy[i];
        }

        return res;
    }
}



