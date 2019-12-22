package com.example.impldemo;

/**
 * @author xukai
 * @date 2019/05/05
 */
public class AppDemo {
    public static void main(String[] args) {
        HumiditySensor humiditySensor = new HumiditySensor();
        humiditySensor.setHumidity(27.0);
        // 传入一个接口的实现
        method(humiditySensor);
    }

    /**
     * 入参为接口
     * @param sensorService
     */
    public static void method(SensorService sensorService) {
        sensorService.report();
    }
}
