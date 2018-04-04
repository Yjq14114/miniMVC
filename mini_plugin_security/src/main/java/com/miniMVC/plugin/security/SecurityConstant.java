package com.miniMVC.plugin.security;

/**
 * Created by yjq14 on 2018/4/4.
 */
public interface SecurityConstant {

    String REALMS = "mini.plugin.security.realms";

    String REALMS_JDBC = "jdbc";

    String REALMS_CUSTOM = "custom";

    String MINI_SECURITY = "mini.plugin.security.custom.class";

    String JDBC_AUTHC_QUERY = "mini.plugin.security.jdbc.authc_query";

    String JDBC_ROLES_QUERY = "mini.plugin.security.jdbc.roles_query";

    String JDBC_PERMISSIONS_QUERY = "mini.plugin.security.jdbc.permissions_query";

    String CACHE = "mini.plugin.security.cache";
}
