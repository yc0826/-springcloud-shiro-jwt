package com.haochen.consumer.shiro.filter;

import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * @author YangChao
 */
public class JwtToken implements HostAuthenticationToken {
    private String token;
    private String host;

    public JwtToken(String token) {
        this(token, null);
    }

    public JwtToken(String token, String host) {
        this.token = token;
        this.host = host;
    }

    public String getToken() {
        return this.token;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String toString() {
        return token + ':' + host;
    }
}
