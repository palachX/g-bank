package app.bank.eventhandler.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {


    @Override
    @SneakyThrows
    public LocalDateTime deserialize(
            final JsonElement jsonElement,
            final Type type,
            final JsonDeserializationContext jsonDeserializationContext
    ) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(
                        jsonElement.getAsLong() / 1000
                ),
                TimeZone.getDefault()
                        .toZoneId()
        );
    }
}
