package com.lance.blog.config;

import com.lance.blog.util.Collections;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Shiro realm
 *
 * @author Lance
 * @date 2018/1/19 16:50
 */
public class VBlogAuthorizingRealm extends AuthorizingRealm {

    private Map<String, String> users = new HashMap<>();
    private Map<String, Set<String>> roleInfoMap = new HashMap<>();
    private Map<String, Set<String>> permInfoMap = new HashMap<>();

    public VBlogAuthorizingRealm() {
        users.put("root", "root");
        users.put("guest", "123");

        roleInfoMap.put("root", Collections.set("admin"));
        roleInfoMap.put("guest", Collections.set("guest"));

        permInfoMap.put("admin", Collections.set("*"));
        permInfoMap.put("admin", Collections.set("grade:*"));
        permInfoMap.put("guest", Collections.set("grade:read"));
        permInfoMap.put("guest", Collections.set("grade:comment"));
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleInfoMap.get(principals.getPrimaryPrincipal().toString()));
        authorizationInfo.setStringPermissions(permInfoMap.get(principals.getPrimaryPrincipal().toString()));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        return new SimpleAuthenticationInfo(
                token.getPrincipal().toString(),
                users.get(token.getPrincipal().toString()),
                "meRealm");
    }

}
