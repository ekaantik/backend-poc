package com.poc.ecard.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@UtilityClass
@Slf4j
public class MapperUtil {

    private static ObjectMapper createMapper() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        return mapper;
    }    private static ObjectMapper mapper = createMapper();

    public static JsonNode readJson(final String json) {
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String toJson(Object obj) {

        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {

        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static <T> T fromJson(final String json, final TypeReference<T> typeRef) {
        try {
            return mapper.readValue(json, typeRef);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static <T> T fromJsonByte(byte[] jsonByte, Class<T> clazz) {

        try {
            return mapper.readValue(jsonByte, clazz);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static <T> T fromFile(String filePath, Class<T> clazz) {
        try {
            InputStream inJson = MapperUtil.class.getClassLoader().getResourceAsStream(filePath);
            return mapper.readValue(inJson, clazz);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


}
