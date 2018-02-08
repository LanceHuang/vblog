package com.lance.blog.config;

import com.lance.blog.dao.IRoleDao;
import com.lance.blog.dao.IUserDao;
import com.lance.blog.dao.IUserRoleDao;
import com.lance.blog.entity.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * Shiro realm
 *
 * @author Lance
 * @date 2018/1/19 16:50
 */
public class VBlogAuthorizingRealm extends AuthorizingRealm {

    @Resource
    private IUserDao userDao;

    @Resource
    private IUserRoleDao userRoleDao;

    @Resource
    private IRoleDao roleDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // TODO: 2018/2/5 It need to query five tables
        String username = principals.getPrimaryPrincipal().toString();

        //Query user id
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(username);
        List<User> userList = userDao.selectByExample(userExample);

        if (!userList.isEmpty() && 1 == userList.size()) {
            //Query role id
            Integer uid = userList.get(0).getId();
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUidEqualTo(uid);
            List<UserRole> userRoleList = userRoleDao.selectByExample(userRoleExample);


            //Query role name
//            RoleExample roleExample = new RoleExample();
//            roleExample.createCriteria().andIdEqualTo();
//
//            List<Role> roleList =

            //Query permission id

            //Query permission name

//            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String username = token.getPrincipal().toString();

        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(username);
        List<User> userList = userDao.selectByExample(userExample);

        if (!userList.isEmpty() && 1 == userList.size()) {
            return new SimpleAuthenticationInfo(
                    username,
                    userList.get(0).getPassword(),
                    "VBlogAuthorizingRealm");
        }

        return null;
    }
}
