package com.example.common;


import org.junit.Test;

import java.util.Random;

/**
 * 随机字符串
 * @author xukai
 * @date 2019/05/10
 */
public class RandomStringTest {
    public static class RandomUtils {
        public static String getRandomString(int length) {
            String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            return sb.toString();
        }

    }

    @Test
    public void testRandomString() {
        System.out.println(RandomUtils.getRandomString(20));
    }
}
