package com.miniMVC.plugin.security.tags;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;


/**
 * Created by yjq14 on 2018/4/5.
 */
public class HasAnyPermissionsTag extends PermissionTag{
    private static final String PERMISSION_NAME_DELIMITER = ",";
    @Override
    protected boolean showTagBody(String s) {
        Subject subject = getSubject();
        if (subject != null) {
            for (String permission :
                    s.split(PERMISSION_NAME_DELIMITER)) {
                if (subject.isPermitted(permission)) {
                    return true;
                }
            }
        }
        return false;
    }
}
