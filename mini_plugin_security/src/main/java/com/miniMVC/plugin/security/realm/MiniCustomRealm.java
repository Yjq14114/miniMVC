package com.miniMVC.plugin.security.realm;

import com.miniMVC.plugin.security.MiniSecurity;
import com.miniMVC.plugin.security.SecurityConfig;
import com.miniMVC.plugin.security.SecurityConstant;
import com.miniMVC.plugin.security.credentials.Md5CredentialsMather;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/4/5.
 */
public class MiniCustomRealm extends AuthorizingRealm{
    private final MiniSecurity miniSecurity;

    public MiniCustomRealm(MiniSecurity miniSecurity) {
        this.miniSecurity = miniSecurity;
        super.setName(SecurityConstant.REALMS_CUSTOM);
        super.setCredentialsMatcher(new Md5CredentialsMather());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new AuthorizationException("parameter principal is null");
        }
        String username = (String) super.getAvailablePrincipal(principalCollection);
        Set<String> roleNameSet = miniSecurity.getRoleNameSet(username);
        Set<String> permissionNameSet = new HashSet<>();
        if (roleNameSet != null && roleNameSet.size() > 0) {
            for (String roleName: roleNameSet) {
                Set<String> currentPermissionNameSet = miniSecurity.getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissionNameSet);
        authorizationInfo.setRoles(roleNameSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken == null) {
            throw new AuthenticationException("parameter token is null");
        }
        String username = ((UsernamePasswordToken) authenticationToken).getUsername();
        String password = miniSecurity.getPassword(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, password));
        authenticationInfo.setCredentials(password);
        return authenticationInfo;
    }
}
