package tddmicroexercises.monitoringsystem.tirepressure;

import java.util.Random;

import tddmicroexercises.monitoringsystem.Sensor;

public class PressureSensor implements Sensor
{
    public static final double OFFSET = 16;

    public double probe()
    {
        double pressureTelemetryValue;
        pressureTelemetryValue = samplePressure( );

        return OFFSET + pressureTelemetryValue;
    }

    private static double samplePressure()
    {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
