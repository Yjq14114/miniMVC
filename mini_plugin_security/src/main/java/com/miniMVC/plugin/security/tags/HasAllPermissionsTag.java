package com.miniMVC.plugin.security.tags;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

import java.util.Arrays;

/**
 * Created by yjq14 on 2018/4/5.
 */
public class HasAllPermissionsTag extends PermissionTag{
    private static final String PERMISSION_NAME_DELIMITER = ",";
    @Override
    protected boolean showTagBody(String s) {
        Subject subject = getSubject();
        if (subject != null) {
            for (String permission :
                    s.split(PERMISSION_NAME_DELIMITER)) {
                boolean permittedAll = subject.isPermittedAll(permission);
                if (!permittedAll) {
                    return false;
                }
            }
        }
        return false;
    }
}
