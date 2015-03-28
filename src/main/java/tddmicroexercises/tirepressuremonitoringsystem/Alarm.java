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

        private double lowerBound;
        private double higherBound;

        public SafetyRange(double lowerBound, double higherBound) {
            this.lowerBound = lowerBound;
            this.higherBound = higherBound;
        }

        public boolean isNotSafe(double value) {
            return value < lowerBound || higherBound < value;
        }
    }
}
