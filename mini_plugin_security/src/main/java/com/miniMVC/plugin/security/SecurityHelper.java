package com.miniMVC.plugin.security;

import com.miniMVC.plugin.security.exception.AuthcException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yjq14 on 2018/4/5.
 */
public final class SecurityHelper {
    private static final Logger logger = LoggerFactory.getLogger(SecurityHelper.class);
    public static void login(String username, String password) throws AuthcException {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            UsernamePasswordToken token = new UsernamePasswordToken();
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                logger.error("login failure", e);
                throw new AuthcException(e);
            }
        }
    }
    public static void logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
    }
}
