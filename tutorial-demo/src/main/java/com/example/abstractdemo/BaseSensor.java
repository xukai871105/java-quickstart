package com.example.abstractdemo;

/**
 * @author xukai
 */
abstract class BaseSensor {
    private Double sensorValue;

    public BaseSensor(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    // 定义一个抽象方法

    /**
     *
     */
    public abstract void report();

    public void show() {
        System.out.println(this.getClass().getName());
    }
}
