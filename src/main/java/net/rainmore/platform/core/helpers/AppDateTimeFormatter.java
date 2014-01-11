package net.rainmore.platform.core.helpers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class AppDateTimeFormatter {

    public final static DateTimeFormatter dateFormatter = ISODateTimeFormat.yearMonthDay();
    public final static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
}
