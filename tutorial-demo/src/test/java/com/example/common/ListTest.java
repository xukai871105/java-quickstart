package com.example.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoxiang.xk
 * @date 2019/07/10
 */
public class ListTest {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // 使用起来像C语言的指针
        addOther(list);
        System.out.println(list);
    }

    private void addOther(List<Integer> list) {
        list.add(3);
        list.add(4);
    }
}
