package com.haochen.consumer.shiro.realm;

import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private MstInterUserBaseService mstInterUserBaseService;
    @Autowired
    private MstInterUserRollService mstInterUserRollService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
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

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String username = (String) token.getPrincipal();
        MstInterUserBaseEntity user = mstInterUserBaseService.findByUsername(username);
        if (user == null) {
            //没找到账号
            throw new UnknownAccountException();
        }

        //帐号锁定
        if (Boolean.FALSE.equals(user.getAppAcesFlg())) {
            throw new LockedAccountException();
        }
        //帐号锁定
        if (Boolean.FALSE.equals(user.getAuthorizedFlg())) {
            throw new UnauthorizedException();
        }
        SecurityUtils.getSubject().getSession().setAttribute(Constants.CURRENT_USER, user);
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(
                //用户名
                user.getUserName(),
                //密码
                user.getUserPwd(),
                //realm name
                getName()
        );
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }


}
