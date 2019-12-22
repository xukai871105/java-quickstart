package com.example.common;

import org.junit.Test;

/**
 * 测试多参数 int...
 * @author xukai
 * @date 2019/11/1
 */
public class MultiParametersTest {

    private void testMulti(int... values) {
        for (int value : values) {
            System.out.println("value: " + value);
        }
    }

    @Test
    public void testCommon() {
        testMulti(1,2,3);
    }
}
