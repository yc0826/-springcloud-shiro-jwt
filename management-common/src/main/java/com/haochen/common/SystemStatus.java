package com.haochen.common;


/**
 * Created on 15/11/7.
 * @author YangChao
 */
public class SystemStatus implements Response {
//
//    /**
//     * http status
//     */
//    HTTP_OK("200", "successful"),
//    HTTP_NOT_FOUND("404", "Not found!"),
//    HTTP_NO_PERMISSION("403", "No permission!"),
//    HTTP_NOT_SUPPORT("405", "Not order method!"),
//    HTTP_ERROR("500", "An error occurred!"),
//    HTTP_OK2("0", "successful"),
//    /**
//     * system exception
//     */
//    SYS_EXCEP("10001", "系统异常"),
//    SYS_RUNTIME_EXCEP("10002", "系统运行时异常"),
//
//    OAUTH_NOT_VALID_ACCESS_TOKEN_NOT_EXPIRES("401", "登录已过期，请重新登录");

    private String code;

    private String msg;

    private Boolean success;

    @Override
    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public SystemStatus() {
    }

    public SystemStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public static SystemStatus HTTP_ERROR() {
        return new SystemStatus("500", "An error occurred!");
    }
    public static SystemStatus HTTP_OK() {
        return new SystemStatus("200", "successful");
    }

    public static SystemStatus HTTP_OK2() {
        return new SystemStatus("0", "successful");
    }
    public static SystemStatus HTTP_NOT_FOUND() {
        return new SystemStatus("404", "Not found!");
    }
    public static SystemStatus HTTP_NO_PERMISSION() {
        return new SystemStatus("403", "No permission!");
    }
    public static SystemStatus HTTP_NOT_SUPPORT() {
        return new SystemStatus("405", "Not order method!");
    }

    public static SystemStatus SYS_EXCEP() {
        return new SystemStatus("10001", "系统异常");
    }

    public static SystemStatus SYS_RUNTIME_EXCEP() {
        return new SystemStatus("10002", "系统运行时异常");
    }

    public static SystemStatus OAUTH_NOT_VALID_ACCESS_TOKEN_NOT_EXPIRES() {
        return new SystemStatus("401", "登录已过期，请重新登录");
    }

    public static SystemStatus OAUTH_NOT_VALID_REFRESH_TOKEN_NOT_EXPIRES() {
        return new SystemStatus("1006", "登录已过期，请重新登录");
    }

    public static SystemStatus PARAM_NUM_ERROR() {
        return new SystemStatus("2022", "参数个数不匹配");
    }

    public static SystemStatus SMS_TEMPLATE_NULL() {
        return new SystemStatus("2013", "无法获取短信模板");
    }

    public static SystemStatus OAUTH_UNSUPPORTED_GRANT_TYPE() {
        return new SystemStatus("1007", "不支持的授权方式");
    }
}
