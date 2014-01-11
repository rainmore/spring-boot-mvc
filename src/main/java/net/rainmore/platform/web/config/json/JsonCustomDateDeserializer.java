package net.rainmore.platform.web.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

public class JsonCustomDateDeserializer extends JsonDeserializer<LocalDate> {
    private static DateTimeFormatter formatter = ISODateTimeFormat.yearMonthDay();

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return formatter.parseLocalDate(jp.getText());
    }

}
