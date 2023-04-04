package main.java.exercise;

import main.java.framework.Report;
import main.java.framework.Timer;
import main.java.framework.Verifier;

public class VerifierImplementation extends Verifier<InstanceImplementation, StudentSolutionImplementation, ResultImplementation> {

    @Override
    public ResultImplementation solveProblemUsingStudentSolution(InstanceImplementation instance, StudentSolutionImplementation studentSolution) {
        if (instance.getGroupName().equals("Maximumsuche")) {
            Timer timer = new Timer();
            timer.start();
            int max = studentSolution.findMax(instance.getNumbers());
            timer.stop();
            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getNumbers().length, max, null, false);
        } else if (instance.getGroupName().equals("Dichtestes Punktepaar")) {
            ClosestPair closestPair = new ClosestPair();
            Timer timer = new Timer();
            timer.start();
            studentSolution.findClosestPair(instance.getPoints(), closestPair);
            timer.stop();
            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getPoints().length, 0, closestPair, false);
        } else {
            Timer timer = new Timer();
            timer.start();
            boolean hasSum = studentSolution.hasSubsetSum(instance.getSum(), instance.getNumbers());
            timer.stop();
            return new ResultImplementation(instance.getGroupName(), timer.getDuration(), instance.getNumbers().length, 0, null, hasSum);
        }
    }

    @Override
    public Report verifyResult(InstanceImplementation instance, ResultImplementation result) {
        if (instance.getGroupName().equals("Maximumsuche")) {
            if (instance.getMaxSolution() == result.getMaxSolution()) {
                return new Report(true, "");
            } else {
                return new Report(false, "Error in instance " + instance.getNumber() + ": Max value expected to be " + instance.getMaxSolution() + " but was " + result.getMaxSolution() + ".");
            }
        } else if (instance.getGroupName().equals("Dichtestes Punktepaar")) {
            if (instance.getPointSolution().equals(result.getPointSolution())) {
                return new Report(true, "");
            } else {
                return new Report(false, "Error in instance " + instance.getNumber() + ": Closest pair expected to be " + instance.getPointSolution().toString() + " but was " + result.getPointSolution().toString() + ".");
            }
        } else {
            if (instance.getSumSolution() == result.getSumSolution()) {
                return new Report(true, "");
            } else {
                if (instance.getSumSolution()) {
                    return new Report(false, "Error in instance " + instance.getNumber() + ": A subset sum exists but was not found.");
                } else {
                    return new Report(false, "Error in instance " + instance.getNumber() + ": No subset sum exists.");
                }
            }
        }
    }
}
