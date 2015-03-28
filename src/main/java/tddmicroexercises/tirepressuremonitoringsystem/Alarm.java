package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
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

    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;
    private SafetyRange safetyRange;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.safetyRange = new SafetyRange(LowPressureThreshold, HighPressureThreshold);
    }

    public void check() {
        double pressure = sensor.probe();

        if (safetyRange.isNotSafe(pressure)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
