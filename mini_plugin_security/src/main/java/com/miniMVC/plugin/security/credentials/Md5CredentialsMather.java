package com.miniMVC.plugin.security.credentials;

import com.miniMVC.commons.CodecUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * Created by yjq14 on 2018/4/4.
 */
public class Md5CredentialsMather implements CredentialsMatcher{
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        UsernamePasswordToken credentials = (UsernamePasswordToken) authenticationToken.getCredentials();
        String actual = String.valueOf(credentials);
        String encrypted = String.valueOf(authenticationInfo.getCredentials());
        return CodecUtil.md5(actual).equals(encrypted);
    }
}
