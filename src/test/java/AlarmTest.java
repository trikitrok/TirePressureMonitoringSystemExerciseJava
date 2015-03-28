import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;
import static org.mockito.Mockito.*;

public class AlarmTest {

    private class FakeAlarm extends Alarm {
        private double pressureSample;

        public FakeAlarm(double pressureSample) {
            this.pressureSample = pressureSample;
        }

        @Override
        protected double probePressure() {
            return pressureSample;
        }
    }

    @Test
    public void alarm_off_for_pressure_in_safe_pressure_range() {
        double pressureSample = 18.0;
        Alarm alarm = new FakeAlarm(pressureSample);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_on_for_pressure_below_safe_pressure_range() {
        double pressureSample = 16.0;
        Alarm alarm = new FakeAlarm(pressureSample);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_on_for_pressure_over_safe_pressure_range() {
        double pressureSample = 22.0;
        Alarm alarm = new FakeAlarm(pressureSample);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_should_accept_the_sensor_dependency() {
        Sensor sensor = mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        verify(sensor).popNextPressurePsiValue();
    }
}
