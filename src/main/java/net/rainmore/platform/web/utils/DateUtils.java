package net.rainmore.platform.web.utils;

import org.joda.time.DateTime;

import java.util.Date;

public class DateUtils {
    public static Date createDate(int year, int month, int date) {
        DateTime dateTime = new DateTime(year, month, date, 0, 0);
        return dateTime.toDate();
    }

    public static Date createDate(int year, int month, int date, int hour, int minute) {
        DateTime dateTime = new DateTime(year, month, date, hour, minute);
        return dateTime.toDate();
    }
}
