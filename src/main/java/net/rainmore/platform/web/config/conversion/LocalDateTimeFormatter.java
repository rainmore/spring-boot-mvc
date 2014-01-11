package net.rainmore.platform.web.config.conversion;

import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDateTime;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return AppDateTimeFormatter.dateTimeFormatter.parseLocalDateTime(text);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return AppDateTimeFormatter.dateTimeFormatter.print(object);
    }
}
