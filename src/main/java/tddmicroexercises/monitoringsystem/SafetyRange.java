package tddmicroexercises.monitoringsystem;

public class SafetyRange {

    private double lowerThreshold;
    private double higherThreshold;

    public SafetyRange(double lowerThreshold, double higherThreshold) {
        this.lowerThreshold = lowerThreshold;
        this.higherThreshold = higherThreshold;
    }

    public boolean isNotSafe(double value) {
        return value < lowerThreshold || higherThreshold < value;
    }
}
