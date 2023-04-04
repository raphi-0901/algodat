package main.java.exercise;

import main.java.framework.PersistAs;
import main.java.framework.Result;

public class ResultImplementation implements Result {

    private String problemType;

    @PersistAs("duration")
    private long duration;

    @PersistAs("size")
    private int size;

    private boolean isSortedXInside;      // Im Intervall [a, b) sortiert? X
    private boolean isSortedXOutside;     // Außerhalb von [a, b) sortiert? X
    private boolean isSortedX;            // Insgesamt sortiert? X
    private boolean isSortedYInside;      // Im Intervall [a, b) sortiert? Y
    private boolean isSortedYOutside;     // Außerhalb von [a, b) sortiert? Y
    private boolean isSortedY;            // Insgesamt sortiert? Y

    private boolean fixedNumbersInside;   // Wurden Zahlen in [a, b) exakt gehalten (ident)?
    private boolean fixedNumbersOutside;  // Wurden Zahlen außerhalb von [a, b) exakt gehalten (ident)?
    private boolean fixedNumbers;         // Wurden Zahlen insgesamt exakt gehalten?

    private boolean keptNumbersInside;    // Wurden Zahlen innerhalb von [a, b) gehalten (bis auf Positionstausch)?
    private boolean keptNumbersOutside;   // Wurden Zahlen außerhalb von [a, b) gehalten (bis auf Positionstausch)?

    private boolean keptNumbers;          // Wurden Zahlen gehalten?
    private boolean noDuplicates;         // Wurden Duplikate erzeugt?

    private boolean splitLeft;            // Stimmen die Zahlen links des Splitpunktes?
    private boolean splitRight;           // Stimmen die Zahlen rechts des Splitpunktes?

    private double bestDist;              // Gesuchte beste Distanz
    private PointPair closestPair;        // Gesuchtes Punktpaar
    private boolean isPointPairFeasible;  // Ist vorgeschlagene Lösung enthalten?
    private boolean isClosestPair;        // Ist die gefundene Lösung (ein) closest Point Pair?
    private boolean isPairNotIdentical;   // Bestimmt, ob das Punktpaar nicht identisch ist.
    private boolean distCorrect;          // Ist die Distanz des Punktpaares korrekt? (Rundungsfehler!)

    private boolean splitValueValid;      // Splitwert valide? (zB bei Random)
    private double splitValue;            // Gesuchter Splitwert
    private int splitPoint;               // Gesuchter Splitpunkt

    public ResultImplementation(String problemType, long duration, int size,
                                boolean isSortedXInside, boolean isSortedXOutside, boolean isSortedX,
                                boolean isSortedYInside, boolean isSortedYOutside, boolean isSortedY,
                                boolean fixedNumbersInside, boolean fixedNumbersOutside, boolean fixedNumbers,
                                boolean keptNumbersInside, boolean keptNumbersOutside,
                                boolean keptNumbers, boolean noDuplicates,
                                boolean splitLeft, boolean splitRight,
                                double bestDist, PointPair closestPair, boolean isPointPairFeasible, boolean isClosestPair,
                                boolean isPairNotIdentical, boolean distCorrect,
                                boolean splitValueValid, double splitValue, int splitPoint) {
        this.problemType = problemType;
        this.duration = duration;
        this.size = size;

        this.isSortedXInside = isSortedXInside;
        this.isSortedXOutside = isSortedXOutside;
        this.isSortedX = isSortedX;

        this.isSortedYInside = isSortedYInside;
        this.isSortedYOutside = isSortedYOutside;
        this.isSortedY = isSortedY;

        this.fixedNumbersInside = fixedNumbersInside;
        this.fixedNumbersOutside = fixedNumbersOutside;
        this.fixedNumbers = fixedNumbers;

        this.keptNumbersInside = keptNumbersInside;
        this.keptNumbersOutside = keptNumbersOutside;

        this.keptNumbers = keptNumbers;
        this.noDuplicates = noDuplicates;

        this.splitLeft = splitLeft;
        this.splitRight = splitRight;

        this.bestDist = bestDist;
        this.closestPair = closestPair;
        this.isPointPairFeasible = isPointPairFeasible;
        this.isClosestPair = isClosestPair;
        this.isPairNotIdentical = isPairNotIdentical;
        this.distCorrect = distCorrect;

        this.splitValueValid = splitValueValid;
        this.splitValue = splitValue;
        this.splitPoint = splitPoint;
    }

    public String getProblemType() {
        return problemType;
    }

    public long getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }

    public boolean isSortedXInside() {
        return isSortedXInside;
    }

    public boolean isSortedXOutside() {
        return isSortedXOutside;
    }

    public boolean isSortedX() {
        return isSortedX;
    }

    public boolean isSortedYInside() {
        return isSortedYInside;
    }

    public boolean isSortedYOutside() {
        return isSortedYOutside;
    }

    public boolean isSortedY() {
        return isSortedY;
    }

    public boolean isFixedNumbersInside() {
        return fixedNumbersInside;
    }

    public boolean isFixedNumbersOutside() {
        return fixedNumbersOutside;
    }

    public boolean isFixedNumbers() {
        return fixedNumbers;
    }

    public boolean isKeptNumbersInside() {
        return keptNumbersInside;
    }

    public boolean isKeptNumbersOutside() {
        return keptNumbersOutside;
    }

    public boolean isKeptNumbers() {
        return keptNumbers;
    }

    public boolean isNoDuplicates() {
        return noDuplicates;
    }

    public boolean isSplitLeft() {
        return splitLeft;
    }

    public boolean isSplitRight() {
        return splitRight;
    }

    public double getBestDist() {
        return bestDist;
    }

    public PointPair getClosestPair() {
        return closestPair;
    }

    public boolean isPointPairFeasible() {
        return isPointPairFeasible;
    }

    public boolean isClosestPair() {
        return isClosestPair;
    }

    public boolean isPairNotIdentical() {
        return isPairNotIdentical;
    }

    public boolean isDistCorrect() {
        return distCorrect;
    }

    public boolean isSplitValueValid() {
        return splitValueValid;
    }

    public double getSplitValue() {
        return splitValue;
    }

    public int getSplitPoint() {
        return splitPoint;
    }
}
