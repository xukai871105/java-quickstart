package com.example.abstractdemo;

/**
 * @author xukai
 * @date 2019/05/05
 */
public class TemperatureSensor extends BaseSensor {

    public TemperatureSensor(Double sensorValue) {
        super(sensorValue);
    }

    @Override
    public void report() {
        System.out.printf("Temperature %.1f\n", super.getSensorValue());
    }
}
