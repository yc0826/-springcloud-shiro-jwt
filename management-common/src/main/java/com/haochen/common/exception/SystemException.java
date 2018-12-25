package com.haochen.common.exception;

import com.haochen.common.SystemStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created on 15/11/7.
 */
public class SystemException extends Exception {
    private SystemStatus systemStatus = null;
    public final static Logger logger = LogManager.getLogger(SystemException.class);

    public SystemException() {
    }

    public SystemException(String code, String message) {
        super(message);

        SystemStatus systemStatus = new SystemStatus(code, message);
        this.systemStatus = systemStatus;
        logger.error(getParentClass() + systemStatus.getMsg());
    }

    public SystemException(String message) {
        super(message);

        SystemStatus systemStatus = new SystemStatus("555", message);
        this.systemStatus = systemStatus;
        logger.error(getParentClass() + message);
    }

    public SystemException(SystemStatus systemStatus) {
        super(systemStatus.getMsg());
        this.systemStatus = systemStatus;
        logger.error(getParentClass() + systemStatus.getMsg());
    }

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }

    public static String getParentClass() {
        try {
            StackTraceElement strack = new Throwable().getStackTrace()[2];
            String className = strack.getClassName().substring(strack.getClassName().lastIndexOf('.') + 1);
            String methodName = strack.getMethodName();
            methodName = methodName + ":" + strack.getLineNumber() + " ";
            return className + "." + methodName;
        } catch (Exception e1) {
            logger.error("输出日志时异常" + e1);
            return "";
        }
    }
}
