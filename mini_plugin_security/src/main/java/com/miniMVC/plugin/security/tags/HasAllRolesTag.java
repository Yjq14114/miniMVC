package com.miniMVC.plugin.security.tags;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.RoleTag;

import java.util.Arrays;


/**
 * Created by yjq14 on 2018/4/5.
 */
public class HasAllRolesTag extends RoleTag{
    private static final String ROLE_NAMES_DELIMITER = ",";
    @Override
    protected boolean showTagBody(String s) {
        boolean hasAllRole = false;
        Subject subject = getSubject();
        if (subject != null) {
            if (subject.hasAllRoles(Arrays.asList(s.split(ROLE_NAMES_DELIMITER)))) {
                hasAllRole = true;
            }
        }
        return hasAllRole;
    }
}
