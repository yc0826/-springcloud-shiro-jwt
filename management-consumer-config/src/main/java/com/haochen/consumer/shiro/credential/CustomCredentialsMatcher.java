package com.haochen.consumer.shiro.credential;

import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.common.utils.PasswordEncryption;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author YangChao
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private MstInterUserBaseService mstInterUserBaseService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        MstInterUserBaseEntity user = mstInterUserBaseService.findByUsername(token.getUsername());

        String hash = null;
        try {
            hash = PasswordEncryption.getEncryptedPassword(new String(token.getPassword()), user.getSalt());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return user.getUserPwd().equals(hash);
    }

}
