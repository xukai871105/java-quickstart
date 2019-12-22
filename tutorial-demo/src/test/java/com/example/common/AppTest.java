package com.example.common;

import org.junit.Test;

public class AppTest {
    @Test
    public void testGetAvailableProcessors() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
