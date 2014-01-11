package net.rainmore.platform.core.helpers.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDate;

import java.io.IOException;

public class JsonCustomDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return AppDateTimeFormatter.dateFormatter.parseLocalDate(jp.getText());
    }

}

