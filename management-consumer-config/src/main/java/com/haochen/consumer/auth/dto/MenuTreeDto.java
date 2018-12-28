package com.haochen.consumer.auth.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangChao
 */
public class MenuTreeDto implements Serializable {

    private String id;

    private String label;

    private String url;

    private String path;

    private String componentPath;

    private Integer depth;

    private String description;

    private String parent_id;

    private Integer child_num;

    private String resoTypeCode;

    private String permission;

    private List<MenuTreeDto> children;

    private String typeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getChild_num() {
        return child_num;
    }

    public void setChild_num(Integer child_num) {
        this.child_num = child_num;
    }

    public List<MenuTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeDto> children) {
        this.children = children;
    }

    public String getResoTypeCode() {
        return resoTypeCode;
    }

    public void setResoTypeCode(String resoTypeCode) {
        this.resoTypeCode = resoTypeCode;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getTypeName() {
        if("00040003".equals(resoTypeCode)) {
            return "菜单";
        } else if("00040004".equals(resoTypeCode)) {
            return "按钮";
        }
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponentPath() {
        return componentPath;
    }

    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }
}
