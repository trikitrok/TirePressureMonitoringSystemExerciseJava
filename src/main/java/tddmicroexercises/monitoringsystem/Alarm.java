package tddmicroexercises.monitoringsystem;

public class Alarm {
    private static final double LOW_THRESHOLD = 17;
    private static final double HIGH_THRESHOLD = 21;

    private Sensor sensor;

    private boolean alarmOn = false;
    private SafetyRange safetyRange;

    public Alarm(Sensor sensor, SafetyRange safetyRange) {
        this.sensor = sensor;
        this.safetyRange = safetyRange;
    }

    public void check() {
        if (safetyRange.isNotSafe(sensor.probe())) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
