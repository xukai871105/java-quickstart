package com.example.impldemo;

/**
 * @author xukai
 * @date 2019/05/05
 */
public class HumiditySensor implements SensorService {

    private Double humidity;

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Override
    public void report() {
        System.out.printf("Humidity %.1f\n", humidity);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
