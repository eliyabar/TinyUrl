package com.siemens.tinyurl.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getExpiredDate(Date date, Integer daysToLive) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, daysToLive);
        return cal.getTime();
    }
}
