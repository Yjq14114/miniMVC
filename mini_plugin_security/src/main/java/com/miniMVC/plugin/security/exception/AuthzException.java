package com.miniMVC.plugin.security.exception;

/**
 * 授权异常（当权限无效时抛出）
 *
 * @author huangyong
 * @since 1.0.0
 */
public class AuthzException extends RuntimeException {

    public AuthzException() {
        super();
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
