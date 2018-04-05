package com.miniMVC.plugin.security.realm;

import com.miniMVC.framework.helper.DatabaseHelper;
import com.miniMVC.plugin.security.SecurityConfig;
import com.miniMVC.plugin.security.credentials.Md5CredentialsMather;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * Created by yjq14 on 2018/4/5.
 */
public class MiniJdbcRealm extends JdbcRealm{

    public MiniJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMather());
    }
}
