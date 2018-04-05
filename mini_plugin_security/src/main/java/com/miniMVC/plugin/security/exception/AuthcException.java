package com.miniMVC.plugin.security.exception;

/**
 * 认证异常（当非法访问时抛出）
 *
 * @author huangyong
 * @since 1.0.0
 */
public class AuthcException extends Exception {

    public AuthcException() {
        super();
    }

    public AuthcException(String message) {
        super(message);
    }

    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
