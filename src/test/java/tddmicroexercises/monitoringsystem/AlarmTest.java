package tddmicroexercises.monitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import tddmicroexercises.monitoringsystem.Alarm;
import tddmicroexercises.monitoringsystem.Sensor;

import static tddmicroexercises.monitoringsystem.helpers.AlarmBuilder.anAlarm;

public class AlarmTest {
    @Test
    public void alarm_is_off_when_detected_value_in_safety_range() {
        Alarm alarm = anAlarm().withSensor(detecting(18.0)).andSafetyRangeBetween(17, 21).build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_is_on_when_detected_value_below_safety_range() {
        Alarm alarm = anAlarm().withSensor(detecting(16.0)).andSafetyRangeBetween(17, 21).build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_on_when_detected_value_over_safety_range() {
        Alarm alarm = anAlarm().withSensor(detecting(22.0)).andSafetyRangeBetween(17, 21).build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_should_ask_the_sensor_to_probe() {
        Sensor sensor = mock(Sensor.class);
        Alarm alarm = new Alarm(sensor, new SafetyRange(17, 21));

        alarm.check();

        verify(sensor).probe();
    }

    private Sensor detecting(double samplePressure) {
        Sensor sensor = mock(Sensor.class);
        doReturn(samplePressure).when(sensor).probe();
        return sensor;
    }
}
