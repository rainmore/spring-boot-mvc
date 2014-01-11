package net.rainmore.platform.web.config.conversion;

import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDate;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return AppDateTimeFormatter.dateFormatter.parseLocalDate(text);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return AppDateTimeFormatter.dateFormatter.print(object);
    }
}
