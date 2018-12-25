package com.haochen.consumer.auth.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author YangChao
 */
public class MenuDto implements Serializable {

    private Set<String> permissions;

    private String resCode;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
