package com.haochen.consumer.shiro.filter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ShiroFilterUtils {
    private final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;

    /**
     * 是否是Ajax请求
     */
    static boolean isAjax(ServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    static boolean ajaxSessionStatus(ServletResponse response, String errorCode) {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("sessionstatus", errorCode);
        return Boolean.FALSE;
    }

}
