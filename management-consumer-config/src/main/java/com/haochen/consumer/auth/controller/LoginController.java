package com.haochen.consumer.auth.controller;

import com.haochen.common.Response;
import com.haochen.common.SystemStatus;
import com.haochen.common.utils.ResultHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangChao
 */
@RestController
public class LoginController {


    @GetMapping("/article")
    public Response article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return ResultHelper.successResp("You are already logged in");
        } else {
            return ResultHelper.successResp("You are guest");
        }
    }

    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response unauthorized() {
        return ResultHelper.infoResp(SystemStatus.OAUTH_NOT_VALID_ACCESS_TOKEN_NOT_EXPIRES());
    }



}
