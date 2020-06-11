package com.thoughtworks.capability.gtb.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateDeserializer extends StdDeserializer<LocalDateTime> {

    protected DateDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Instant instant = Instant.ofEpochMilli(p.getLongValue());
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("+8"));
        return dateTime;
    }
}