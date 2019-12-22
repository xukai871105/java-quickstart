package com.example.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试Lambada表达式
 * @author xukai
 * @date 2019/07/24
 */
public class ListStreamTest {

    @Test
    public void testCommon() {
        List<String> list = Arrays.asList("taobao", "tmall");
        list.forEach((d) -> {
            System.out.println(d);
            System.out.println(d);
        });
    }

    @Test
    public void testCommonReturn() {
        List<Integer> list = Arrays.asList(1,5,8,9,6,7,4);
        list.forEach(e ->{
            if( e >= 5) {
                return;
            }
            System.out.println(e);
        });

    }
}
