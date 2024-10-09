package com.cts.eas.ipm.connector.suppliers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.scala.DefaultScalaModule$;

import java.util.Map;

public final class ObjectMapperSupplier {

    private static final ObjectMapper MAPPER =
            new ObjectMapper()
                    .registerModule(new Jdk8Module())
                    .registerModule(DefaultScalaModule$.MODULE$)
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    private ObjectMapperSupplier() {
    }

    public static ObjectMapper getMapperInstance() {
        return MAPPER;
    }

    public static Object convertToObj(String req) throws JsonProcessingException {
        return MAPPER.readValue(req, new TypeReference<Map<String, Object>>() {
        });
    }

    public static ObjectMapper getCopy() {
        return MAPPER.copy();
    }
}