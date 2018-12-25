package com.haochen.provider.auth.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangChao
 */
public class UserInfoOutputBean implements Serializable {

    private String name;

    private List<String> roles;

    private List<UserMenu> menus;

    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<UserMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<UserMenu> menus) {
        this.menus = menus;
    }
}
