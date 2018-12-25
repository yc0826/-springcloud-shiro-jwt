package com.haochen.common;

import java.io.Serializable;

/**
 * Created on 15/11/7.
 */
public interface Response extends Serializable {
    String getCode();
    String getMsg();
    Boolean isSuccess();
}
