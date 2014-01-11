package net.rainmore.platform.core.helpers.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDateTime;

import java.io.IOException;

public class JsonCustomDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(AppDateTimeFormatter.dateTimeFormatter.print(value));
    }
}
