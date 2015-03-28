package tddmicroexercises.monitoringsystem.helpers;

import tddmicroexercises.monitoringsystem.Alarm;
import tddmicroexercises.monitoringsystem.SafetyRange;
import tddmicroexercises.monitoringsystem.Sensor;

public class AlarmBuilder {
    private SafetyRange safetyRange;
    private Sensor sensor;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder withSensor(Sensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilder andSafetyRangeBetween(double lowerThreshold, double higherThreshold) {
        this.safetyRange = new SafetyRange(lowerThreshold, higherThreshold);
        return this;
    }

    public Alarm build() {
        return new Alarm(this.sensor, this.safetyRange);
    }
}
