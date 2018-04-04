package com.miniMVC.plugin.security;

import com.miniMVC.framework.ConfigHelper;
import com.miniMVC.framework.ReflectionUtil;

/**
 * Created by yjq14 on 2018/4/4.
 */
public final class SecurityConfig {
    public static String getRealms() {
        return ConfigHelper.getString(SecurityConstant.REALMS);
    }

    public static MiniSecurity getMiniSecurity() {
        String className = ConfigHelper.getString(SecurityConstant.MINI_SECURITY);
        return (MiniSecurity) ReflectionUtil.newInstance(className);
    }

    public static String getJdbcAuthcQuery() {
        return ConfigHelper.getString(SecurityConstant.JDBC_AUTHC_QUERY);
    }

    public static String getJdbcRolesQuery() {
        return ConfigHelper.getString(SecurityConstant.JDBC_ROLES_QUERY);
    }

    public static String getJdbcPermissionsQuery () {
        return ConfigHelper.getString(SecurityConstant.JDBC_PERMISSIONS_QUERY);
    }

    public static boolean isCache() {
        return ConfigHelper.getBoolean(SecurityConstant.CACHE);
    }
}
