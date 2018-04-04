package com.miniMVC.plugin.security;

import java.util.Set;

/**
 * Created by yjq14 on 2018/4/4.
 */
public interface MiniSecurity {
    String getPassword(String username);

    Set<String> getRoleNameSet(String username);

    Set<String> getPermissionNameSet(String roleName);
}
