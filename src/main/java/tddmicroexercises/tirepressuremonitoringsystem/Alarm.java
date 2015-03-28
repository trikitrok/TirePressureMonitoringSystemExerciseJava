package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private static final double LOW_THRESHOLD = 17;
    private static final double HIGH_THRESHOLD = 21;

    private Sensor sensor;

    private boolean alarmOn = false;
    private SafetyRange safetyRange;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.safetyRange = new SafetyRange(LOW_THRESHOLD, HIGH_THRESHOLD);
    }

    public void check() {
        if (safetyRange.isNotSafe(sensor.probe())) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    private class SafetyRange {

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
}
