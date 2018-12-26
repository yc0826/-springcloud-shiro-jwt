package com.haochen.consumer.shiro.credential;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @author YangChao
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {

    private static final Logger logger = LogManager.getLogger(JwtCredentialsMatcher.class);

    @Resource
    private MstInterUserBaseService mstInterUserBaseService;
    /**
     * Matcher中直接调用工具包中的verify方法即可
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String token = (String) authenticationToken.getCredentials();
        Object stored = authenticationInfo.getCredentials();
        String salt = stored.toString();

        MstInterUserBaseEntity user = (MstInterUserBaseEntity) authenticationInfo.getPrincipals().getPrimaryPrincipal();
        try {
            Algorithm algorithm = Algorithm.HMAC256(salt);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", user.getUserName())
                    .build();
            verifier.verify(token);
            return mstInterUserBaseService.checkJwtToken(token) > 0;
        } catch (UnsupportedEncodingException | JWTVerificationException e) {
            logger.error("Token Error:{}", e.getMessage());
        }
        return false;
    }
}


