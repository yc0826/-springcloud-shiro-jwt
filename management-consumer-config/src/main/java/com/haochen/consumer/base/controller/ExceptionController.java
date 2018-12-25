package com.haochen.consumer.base.controller;

import com.haochen.common.Response;
import com.haochen.common.SystemStatus;
import com.haochen.common.utils.ResultHelper;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangChao
 */
@RestControllerAdvice
public class ExceptionController {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Response handle401(ShiroException e) {
        return ResultHelper.infoResp(SystemStatus.OAUTH_NOT_VALID_ACCESS_TOKEN_NOT_EXPIRES());
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response handle401() {
        return ResultHelper.infoResp(SystemStatus.OAUTH_NOT_VALID_ACCESS_TOKEN_NOT_EXPIRES());
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response globalException(Throwable ex) {
        return ResultHelper.errorResp(ex);
    }

}
