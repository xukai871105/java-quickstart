package com.example.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author xukai
 * @date 2019/11/26
 */
public class ApacheDateTimeUtilTest {

    @Test
    public void testCommon() {

        Date date = new Date();
        // 格式化Date类型时间
        String dateString = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");

        System.out.println("date string: " + dateString);
    }
}
