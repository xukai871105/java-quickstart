package com.example.common;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

/**
 * @author xukai
 * @date 2019/06/19
 */
public class AppJodaTimeTest {
    @Test
    public void test() {
        DateTime dt = new DateTime(2019, 3, 21, 20, 04, 0);
        String str = ISODateTimeFormat.dateTimeNoMillis().print(dt);
        System.out.println(str);
    }
}
