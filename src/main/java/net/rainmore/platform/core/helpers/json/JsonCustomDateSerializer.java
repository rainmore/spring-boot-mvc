package net.rainmore.platform.core.helpers.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.rainmore.platform.core.helpers.AppDateTimeFormatter;
import org.joda.time.LocalDate;

import java.io.IOException;

public class JsonCustomDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(AppDateTimeFormatter.dateFormatter.print(value));
    }
}
