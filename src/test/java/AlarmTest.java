import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;
import static org.mockito.Mockito.*;

public class AlarmTest {

    @Test
    public void alarm_off_for_pressure_in_safe_pressure_range() {
        Alarm alarm = new Alarm(sensorThatDetects(18.0));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_on_for_pressure_below_safe_pressure_range() {
        Alarm alarm = new Alarm(sensorThatDetects(16.0));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_on_for_pressure_over_safe_pressure_range() {
        Alarm alarm = new Alarm(sensorThatDetects(22.0));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_should_ask_the_sensor_to_probe() {
        Sensor sensor = mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        verify(sensor).probe();
    }

    private Sensor sensorThatDetects(double samplePressure) {
        Sensor sensor = mock(Sensor.class);
        doReturn(samplePressure).when(sensor).probe();
        return sensor;
    }

}
