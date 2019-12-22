package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xukai
 */
public class HelloWorld {
    private static  Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    public static void main(String[] args) {
        logger.info("Hello World");

        // 占位符使用
        String stringA = "A";
        String stringB = "B";
        logger.info("{} {}", stringA, stringB);
    }
}
