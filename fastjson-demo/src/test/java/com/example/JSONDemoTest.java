package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;

public class JSONDemoTest {

    @Test
    public void testToJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "xukai");
        jsonObject.put("age", 18);
        jsonObject.put("salary", new BigDecimal("5000.0"));

        // 方法1
        System.out.println(jsonObject.toJSONString());
        // 方法2 格式化打印
        System.out.println(JSON.toJSONString(jsonObject, true));
    }
}
