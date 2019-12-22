package com.example.abstractdemo;

import java.awt.font.TextMeasurer;

/**
 * @author xukai
 * @date 2019/05/05
 */
public class AppDemo {
    public static void main(String[] argv) {
        TemperatureSensor temperatureSensor = new TemperatureSensor(2.0);
        // 调用一个有抽象类的方法
        temperatureSensor.show();
        // 调用一个被实现的抽象方法
        temperatureSensor.report();
    }
}
