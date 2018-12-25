package com.haochen.consumer.shiro.realm;

import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.consumer.shiro.filter.JWTToken;
import com.haochen.consumer.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author YangChao
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private MstInterUserBaseService mstInterUserBaseService;
    @Autowired
    private MstInterUserRollService mstInterUserRollService;


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = principals.toString();
        Session session = SecurityUtils.getSubject().getSession();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = (Set<String>) session.getAttribute("roles");
        if (CollectionUtils.isEmpty(roles)) {
            roles = mstInterUserRollService.findRoles(username);
        }
        session.setAttribute("roles", roles);
        authorizationInfo.setRoles(roles);
        Set<String> permissions = (Set<String>) session.getAttribute("permissions");
        if (CollectionUtils.isEmpty(permissions)) {
            permissions = mstInterUserRollService.findPermissions(username);
        }
        session.setAttribute("permissions", permissions);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new UnauthorizedException("token invalid");
        }
        MstInterUserBaseEntity user = mstInterUserBaseService.findByUsername(username);
        if (user == null) {
            throw new UnauthorizedException("User didn't existed!");
        }
        if (!JWTUtil.verify(token, username, user.getUserPwd())) {
            throw new UnauthorizedException("Username or password error");
        }

        return new SimpleAuthenticationInfo(username, token, "my_realm");
    }
}
