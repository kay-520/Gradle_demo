package com.digitalchina.sc.demo.common.exp;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * ================================================
 * <p>
 * Title:
 * <p>
 * Description:
 * <p>
 * Date: 2018/3/20 10:30
 * <p>
 * ================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class ServiceException extends NestedRuntimeException {

    private static final long serialVersionUID = 2439358964127843952L;

    private Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ServiceException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
