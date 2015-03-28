package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double pressure = sensor.popNextPressurePsiValue();

        if (isPressureOutsideSafeRange(pressure)) {
            alarmOn = true;
        }
    }

    private boolean isPressureOutsideSafeRange(double pressure) {
        return pressure < LowPressureThreshold || HighPressureThreshold < pressure;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
