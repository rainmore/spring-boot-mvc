package net.rainmore.platform.web.config.json;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JsonCustomDateFormatter {

    public final static DateTimeFormatter dateFormatter = ISODateTimeFormat.yearMonthDay();
    public final static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
}
