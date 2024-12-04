package com.ikigai.kiwi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper {
    public static ObjectMapper getMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//k cần dấu ngoặc kép
        objectMapper.configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true);//cho phép dấu phẩy ở cuối
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);// cho phép rỗng
        objectMapper.getFactory().enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);//cho phép dấu nháy đơn
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
