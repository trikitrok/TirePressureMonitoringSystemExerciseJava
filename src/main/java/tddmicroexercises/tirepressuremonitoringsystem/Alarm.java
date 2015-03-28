package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private class SafeRange {

        private double lowerBound;
        private double higherBound;

        public SafeRange(double lowerBound, double higherBound) {
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
    private SafeRange safeRange;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.safeRange = new SafeRange(LowPressureThreshold, HighPressureThreshold);
    }

    public void check() {
        double pressure = sensor.probePressure();

        if (safeRange.isNotSafe(pressure)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
