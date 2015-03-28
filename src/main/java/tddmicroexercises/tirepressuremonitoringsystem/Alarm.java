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
        double psiPressureValue = probePressure();

        if (isPressureOutsideSafeRange(psiPressureValue)) {
            alarmOn = true;
        }
    }

    private boolean isPressureOutsideSafeRange(double psiPressureValue) {
        return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
    }

    protected double probePressure() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
