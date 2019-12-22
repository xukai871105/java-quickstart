package com.example.common;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Java 随机数
 * @author xukai
 * @date 2019/05/09
 */
public class RandomTest {

    @Test
    public void testRandomDouble() {
        double minValue = -20;
        double maxValue = 120;
        double randomValue = new Random().nextDouble() * (maxValue - minValue) + minValue;

        System.out.println(BigDecimal.valueOf(randomValue));
        // 精度控制
        System.out.println(new DecimalFormat("#.#").format(3.1415));
    }

    @Test
    public void testRandomInteger() {
        Integer randomValue = 100 + new Random().nextInt(100) + 1;
        System.out.println(randomValue);
    }
}
