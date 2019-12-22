package com.example.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AppTest {
    @Test
    public void testGetAvailableProcessors() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void testArraysAsList() {
        List<String> list = Arrays.asList("taobao", "tmall");
        list.forEach((d) -> {
            System.out.println(d);
            System.out.println(d);
        });
    }

}
