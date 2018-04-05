package com.miniMVC.plugin.security;

import com.miniMVC.plugin.security.realm.MiniCustomRealm;
import com.miniMVC.plugin.security.realm.MiniJdbcRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/4/4.
 */
public class MiniSecurityFilter extends ShiroFilter{

    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();
        setRealms(webSecurityManager);
        setCache(webSecurityManager);
    }
    private void setRealms(WebSecurityManager webSecurityManager) {
        String realms = SecurityConfig.getRealms();
        if (realms != null) {
            String[] split = realms.split(",");
            if (split.length > 0) {
                Set<Realm> realmSet = new LinkedHashSet<>();
                for (String securityRealm:split) {
                   if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM))
                       addCustomRealm(realmSet);
                   if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC))
                       setJdbcRealm(realmSet);
                }
                RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
                realmSecurityManager.setRealms(realmSet);
            }
        }
    }

    private void addCustomRealm(Set<Realm> realms) {
        MiniSecurity miniSecurity = SecurityConfig.getMiniSecurity();
        MiniCustomRealm customRealm = new MiniCustomRealm(miniSecurity);
        realms.add(customRealm);
    }

    private void setJdbcRealm(Set<Realm> realms) {
        MiniJdbcRealm jdbcRealm = new MiniJdbcRealm();
        realms.add(jdbcRealm);
    }
    private void setCache(WebSecurityManager webSecurityManager) {
        if (SecurityConfig.isCache()) {
            CachingSecurityManager cachingSecurityManager = (CachingSecurityManager) webSecurityManager;
            CacheManager cacheManager = new MemoryConstrainedCacheManager();
            cachingSecurityManager.setCacheManager(cacheManager);
        }
    }
}
