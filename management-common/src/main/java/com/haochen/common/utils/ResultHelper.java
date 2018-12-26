package com.haochen.common.utils;


import com.alibaba.fastjson.JSONObject;
import com.haochen.common.ApiResponse;
import com.haochen.common.SystemStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created on 15/11/10.
 * @author YangChao
 */
public class ResultHelper {
    private final static Logger logger = LogManager.getLogger(ResultHelper.class);

    public static ApiResponse successResp() {
        return successResp(null);
    }

    public static <T> ApiResponse successResp(T t) {
        ApiResponse response = new ApiResponse(SystemStatus.HTTP_OK());
        response.setData(t);
        response.setSuccess(true);
        logger.info("Response:" + JSONObject.toJSONString(response));
        return response;
    }

    public static <T> ApiResponse successRespNoLog(T t) {
        ApiResponse response = new ApiResponse(SystemStatus.HTTP_OK());
        response.setData(t);
        response.setSuccess(true);

        logger.info("Response: too long no print");
        return response;
    }

    public static <T> ApiResponse successResp(T t, String token) {
        ApiResponse response = new ApiResponse(SystemStatus.HTTP_OK());
        response.setData(t);
        response.setSuccess(true);
        return response;
    }

    /**
     * spring框架捕获到未处理异常后会调用这个方法返回错误信息
     *
     * @param logger
     * @param t
     * @return
     */
    public static ApiResponse errorResp(Logger logger, Throwable t) {
        logger.error(t.getMessage(), t);
        if (StringUtil.isEmpty(t.getMessage())) {
            //wangtao 20160907 修复当t.getMessage()为null时，输出的错误信息为上一次报错内容
            return infoResp(SystemStatus.HTTP_ERROR(), t.toString());
        } else {
            return infoResp(SystemStatus.HTTP_ERROR(), t.getMessage());
        }
    }

    public static ApiResponse errorResp(Throwable t) {
        return errorResp(LogManager.getLogger(ResultHelper.class), t);
    }


    public static ApiResponse infoResp(SystemStatus status, String message) {
        if ("500".equals(status.getCode())) {
            status.setMsg("An error occurred!");
        } else {
            //status.setMessage(StringUtils.isEmpty(message) ? status.getMessage() : message);
            status.setMsg(message);
        }
        return infoResp(status);
    }


    public static ApiResponse infoResp(SystemStatus status) {
        ApiResponse apiResponse = new ApiResponse(status);
        if ("An error occurred!".equals(status.getMsg()) || "555".equals(status.getCode())) {
            if ("500".equals(status.getCode())) {
                apiResponse.setMsg("服务繁忙，请稍后再试");
            }
            apiResponse.setSuccess(false);
        }
        if (apiResponse.isSuccess() == null) {
            apiResponse.setSuccess(false);
        }

        return apiResponse;
    }

    public static ApiResponse pingResp(SystemStatus status) {
        ApiResponse apiResponse = new ApiResponse(status);
        apiResponse.setSuccess(true);
        return apiResponse;
    }

}


