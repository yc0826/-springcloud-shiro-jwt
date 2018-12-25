package com.haochen.common;


/**
 * Created on 15/11/7.
 * @author YangChao
 */
public class ApiResponse implements Response {

    String code;

    String msg;

    Boolean success;

    Object data;

    public ApiResponse() {

    }

    public ApiResponse(SystemStatus systemStatus) {
        this.code = systemStatus.getCode();
        this.msg = systemStatus.getMsg();
    }

    public ApiResponse(Object data) {
        this.data = data;
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

    @Override
    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
