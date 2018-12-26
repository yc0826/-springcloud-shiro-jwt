package com.haochen.consumer.shiro.realm;

import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.consumer.shiro.filter.JwtToken;
import com.haochen.consumer.util.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangChao
 */
public class JwtShiroRealm extends AuthorizingRealm {

    @Autowired
    private MstInterUserBaseService mstInterUserBaseService;
    @Autowired
    private MstInterUserRollService mstInterUserRollService;


    /**
     * 限定这个Realm只支持我们自定义的JWT Token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 更controller登录一样，也是获取用户的salt值，给到shiro，由shiro来调用matcher来做认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authcToken;
        String token = jwtToken.getToken();

        MstInterUserBaseEntity user = mstInterUserBaseService.findByUsername(JwtUtils.getUsername(token));
        if(user == null) {
            throw new AuthenticationException("token过期，请重新登录");
        }

        return new SimpleAuthenticationInfo(user, user.getSalt(), "jwtRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        MstInterUserBaseEntity mstInterUserBaseEntity = (MstInterUserBaseEntity) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(mstInterUserRollService.findRoles(mstInterUserBaseEntity.getUserName()));
        authorizationInfo.setStringPermissions(mstInterUserRollService.findPermissions(mstInterUserBaseEntity.getUserName()));
        return authorizationInfo;
    }
}
