package com.haochen.consumer.base.controller;

import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangChao
 */
public class BaseController {

    protected static final Integer PAGE_SIZE = 10;

    public Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }


    protected MstInterUserBaseEntity getCurrentUser() {
        MstInterUserBaseEntity user = (MstInterUserBaseEntity) getSession().getAttribute(Constants.CURRENT_USER);
        if (user != null) {
            return user;
        }
        return null;
    }

    /**
     * 根据token返回当前用户的userCode
     */
    protected String getCurrentUserCode() {
        MstInterUserBaseEntity user = getCurrentUser();
        if (user != null && user.getInterUserCode() != null) {
            return user.getInterUserCode();
        }
        return null;
    }


    /**
     * 根据token返回当前用户的userCode
     */
    protected String getCurrentUserSubsyCodes() {
        MstInterUserBaseEntity user = getCurrentUser();
        if (user != null && user.getSubsyCodes() != null) {
            return user.getSubsyCodes();
        }
        return null;
    }

    public HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) ra).getRequest();
    }

    public HttpServletResponse getResponse() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) ra).getResponse();
    }
}
