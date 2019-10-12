package com.digitalchina.sc.demo.common.base.web.message;

import cn.hutool.http.HttpStatus;
import com.digitalchina.sc.demo.common.base.util.JsonMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * <p>================================================
 * <p>Title: 响应消息
 * <p>Description: controller中处理后，返回此对象，响应请求结果给客户端。
 * <p>Date: 2018/2/28 21:14
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 1085564299395800188L;

    /**
     * 响应状态码
     *
     * @see HttpStatus
     */
    protected Integer code;

    /**
     * 响应消息，用于描述响应结果
     */
    protected String message;

    /**
     * 响应数据
     */
    protected T data;

    /**
     * 服务器时间戳
     */
    private Long timestamp;

    /**
     * 过滤字段：指定需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> includes;

    /**
     * 过滤字段：指定不需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> excludes;

    public boolean success() {
        return code == HttpStatus.HTTP_OK;
    }

    public static <T> ResponseMessage<T> error(String message) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, message);
    }

    public static <T> ResponseMessage<T> error(int code, String message) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        return msg.code(code)
                .putTimeStamp()
                .message(message);
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    public static <T> ResponseMessage<T> ok(T result) {
        return new ResponseMessage<T>()
                .code(HttpStatus.HTTP_OK)
                .putTimeStamp()
                .message("success")
                .result(result);
    }

    public ResponseMessage<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseMessage<T> result(T result) {
        this.data = result;
        return this;
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    private ResponseMessage<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseMessage<T> include(Class<?> type, String... fields) {
        return include(type, Arrays.asList(fields));
    }

    public ResponseMessage<T> include(Class<?> type, Collection<String> fields) {
        if (includes == null) {
            includes = Maps.newHashMap();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        fields.forEach(field -> {
            if (field.contains(".")) {
                String[] tmp = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        include(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFromMap(includes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage<T> exclude(Class type, Collection<String> fields) {
        if (excludes == null) {
            excludes = Maps.newHashMap();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        fields.forEach(field -> {
            if (field.contains(".")) {
                String[] tmp = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        exclude(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFromMap(excludes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage<T> exclude(Collection<String> fields) {
        if (excludes == null) {
            excludes = Maps.newHashMap();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        Class type;
        if (getData() != null) {
            type = getData().getClass();
        } else {
            return this;
        }
        exclude(type, fields);
        return this;
    }

    public ResponseMessage<T> include(Collection<String> fields) {
        if (includes == null) {
            includes = Maps.newHashMap();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        Class type;
        if (getData() != null) {
            type = getData().getClass();
        } else {
            return this;
        }
        include(type, fields);
        return this;
    }

    public ResponseMessage<T> exclude(Class type, String... fields) {
        return exclude(type, Arrays.asList(fields));
    }

    public ResponseMessage<T> exclude(String... fields) {
        return exclude(Arrays.asList(fields));
    }

    public ResponseMessage<T> include(String... fields) {
        return include(Arrays.asList(fields));
    }

    protected Set<String> getStringListFromMap(Map<Class<?>, Set<String>> map, Class type) {
        return map.computeIfAbsent(type, k -> Sets.newHashSet());
    }

    @Override
    public String toString() {
        return JsonMapper.getInstance().toJson(this);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<Class<?>, Set<String>> getExcludes() {
        return excludes;
    }

    public Map<Class<?>, Set<String>> getIncludes() {
        return includes;
    }
}
