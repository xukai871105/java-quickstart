package com.example.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xukai
 */
public class JavaDateTimeTest {

    /**
     * 设置一个时间 并时间并格式化
     */
    @Test
    public void testDateTimeFormat() {
        // 月份从1开始
        DateTime dt = new DateTime(2019, 3, 21, 20, 4, 23);

        String dateString = DateFormatUtils.format(dt.toDate(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateString);
    }

    /**
     * 全部使用 JDK函数
     */
    @Test
    public void testDateTimeFormatUseCalendar() {
        Calendar calendar = Calendar.getInstance();
        // 月份从0开始
        calendar.set(2019,2,21,20,4,23);

        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        System.out.println(dateString);
    }
}
