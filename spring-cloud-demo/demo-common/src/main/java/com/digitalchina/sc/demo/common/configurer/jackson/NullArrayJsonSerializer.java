package com.digitalchina.sc.demo.common.configurer.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * <p>================================================
 * <p>Title:
 * <p>Description:
 * <p>Date: 2018/3/14 18:11
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class NullArrayJsonSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (value == null) {
            jgen.writeStartArray();
            jgen.writeEndArray();
        } else {
            jgen.writeObject(value);
        }
    }
}
