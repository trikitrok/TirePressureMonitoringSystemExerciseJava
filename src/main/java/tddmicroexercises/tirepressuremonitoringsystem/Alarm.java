package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor = new Sensor();

    private boolean alarmOn = false;

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
