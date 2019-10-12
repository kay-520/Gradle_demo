package com.digitalchina.sc.demo.common.configurer.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * ================================================
 * <p>
 * Title:
 * <p>
 * Description:
 * <p>
 * Date: 2018/3/14 18:11
 * <p>
 * ================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class MyBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List<BeanPropertyWriter> beanProperties) {
        // 循环所有的beanPropertyWriter
        for (BeanPropertyWriter writer : beanProperties) {
            Class<?> clazz = writer.getType().getRawClass();
            // 判断字段的类型，如果是array，list，set则注册nullSerializer
            if (isArrayType(clazz)) {
                // 给writer注册一个自己的nullSerializer
                writer.assignNullSerializer(this.defaultNullArrayJsonSerializer());
            }
            if (isString(clazz)) {
                writer.assignNullSerializer(this.defaultNullStringJsonSerializer());
            }
            // 处理long转string
            if (isLong(clazz)) {
                writer.assignSerializer(new ToStringSerializer());
            }

        }
        return beanProperties;
    }

    // 判断是什么类型
    protected boolean isArrayType(Class<?> clazz) {
        return clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class);
    }

    // 判断是什么类型
    protected boolean isString(Class<?> clazz) {
        return clazz.equals(String.class);
    }

    protected boolean isLong(Class<?> clazz) {
        return clazz.equals(Long.class);
    }

    protected JsonSerializer<Object> defaultNullArrayJsonSerializer() {
        return new NullArrayJsonSerializer();
    }

    protected JsonSerializer<Object> defaultLocalDateTimeSerializer() {
        return new NullDateJsonSerializer();
    }

    protected JsonSerializer<Object> defaultNullStringJsonSerializer() {
        return new NullStringJsonSerializer();
    }
}
