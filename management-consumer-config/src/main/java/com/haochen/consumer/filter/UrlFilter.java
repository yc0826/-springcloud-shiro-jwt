package com.haochen.consumer.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author wangtao
 * @date 2016/2/3
 */
public class UrlFilter implements Filter {

    private final static Logger logger = LogManager.getLogger(UrlFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod() == null ? "" : request.getMethod();
        String requestUrl = request.getRequestURL() == null ? "" : request.getRequestURL().toString();
        String clientIp = getIpAddr(request);
        String requestInfo = "ClientIP:" + clientIp + " " + method + ":" + request.getRequestURL() + (request.getQueryString() == null ? "" : "?" + request.getQueryString()) + (request.getParameterMap() == null || request.getParameterMap().size() == 0 ? "" : " @ParameterMap:" + JSONObject.toJSONString(request.getParameterMap()));
        request.setAttribute("RequestInfo", requestInfo);
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            if (request.getContentType() == null || !request.getContentType().toLowerCase().startsWith("multipart/")) {
                ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
                HttpServletRequest req = (HttpServletRequest) requestWrapper;
                String body = HttpHelper.getBodyString(requestWrapper);
                //过滤掉static目录的请求，但排除.apk、html的请求
                if (!requestUrl.contains("/static/") || requestUrl.endsWith(".apk") || requestUrl.contains(".html")) {
                    if (!requestUrl.endsWith("/ping")) {
                        String token = this.getHeadInfo(req);
                        if (body.contains("\n")) {
                            body = body.replaceAll("[\r\n]", "");
                        }
                        logger.info(requestWrapper.getAttribute("RequestInfo") + "   |||   Request json: (" + token + ") " + body);
                    }
                }
                // Pass request back down the filter chain
                filterChain.doFilter(requestWrapper, servletResponse);
            } else {
                //过滤掉static目录的请求，但排除.apk、html的请求
                if (!requestUrl.contains("/static/") || requestUrl.endsWith(".apk") || requestUrl.contains(".html")) {
                    if (!requestUrl.endsWith("/ping")) {
                        String token = this.getHeadInfo(request);
                        logger.info(request.getAttribute("RequestInfo") + "   |||   Request json: (" + token + ") ");
                    }
                }
                // Pass request back down the filter chain
                filterChain.doFilter(request, servletResponse);
            }

        } else {
            //过滤掉static目录的请求，但排除.apk、html的请求
            if (!requestUrl.contains("/static/") || requestUrl.endsWith(".apk") || requestUrl.contains(".html")) {
                if (!requestUrl.endsWith("/ping")) {
                    String token = this.getHeadInfo(request);
                    logger.info(request.getAttribute("RequestInfo") + "   |||   Request json: (" + token + ") ");
                }
            }
            // Pass request back down the filter chain
            filterChain.doFilter(request, servletResponse);
        }

    }

    private String getHeadInfo(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String appKey = request.getHeader("appKey");
        String appVer = request.getHeader("appVer");
        String osVer = request.getHeader("osVer");
        String deviceType = request.getHeader("deviceType");
        return "Authorization=" + authorization + "&appKey=" + appKey + "&appVer=" + appVer + "&osVer=" + osVer + "&deviceType=" + deviceType;
    }


    @Override
    public void destroy() {

    }


}









