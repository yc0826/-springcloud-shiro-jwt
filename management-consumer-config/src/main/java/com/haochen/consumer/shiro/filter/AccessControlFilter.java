package com.haochen.consumer.shiro.filter;

import com.haochen.common.Constants;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author YangChao
 */
public class AccessControlFilter extends org.apache.shiro.web.filter.AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
            // If principal is not null, then the user is known and should be allowed access.
            return subject.getPrincipal() != null;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //判断是不是Ajax请求
        if (ShiroFilterUtils.isAjax(request)) {
            return ShiroFilterUtils.ajaxSessionStatus(response, Constants.AJAX_ERROR_300);
        }
        redirectToLogin(request, response);
        return Boolean.FALSE;
    }




}