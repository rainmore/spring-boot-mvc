package net.rainmore.platform.core.helpers.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDateTime;

import java.io.IOException;

public class JsonCustomDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return AppDateTimeFormatter.dateTimeFormatter.parseLocalDateTime(jp.getText());
    }
}

