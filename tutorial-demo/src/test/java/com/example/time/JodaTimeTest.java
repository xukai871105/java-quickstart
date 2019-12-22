package com.example.time;

import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

/**
 * @author xukai
 * @date 2019/06/19
 */
public class JodaTimeTest {
    @Test
    public void testCommon() {
        DateTime dt = new DateTime(2019, 3, 21, 20, 04, 0);
        String str = ISODateTimeFormat.dateTimeNoMillis().print(dt);
        System.out.println(str);
    }

    @Test
    public void testDateTimeFormat() {
        // 打印当前时间
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        System.out.println(fmt.print(LocalDateTime.now()));

        fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(fmt.print(LocalDateTime.now()));
    }
}
