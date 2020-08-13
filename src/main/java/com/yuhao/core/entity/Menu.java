package com.yuhao.core.entity;

import java.util.Date;
import java.util.List;

public class Menu {
    private String id;
    private String displayNameCn;
    private String displayNameEn;
    private String parentId;
    private String type;
    private String operate;
    private String icon;
    private String url;
    private String otherAction;
    private Date createDate;
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayNameCn() {
        return displayNameCn;
    }

    public void setDisplayNameCn(String displayNameCn) {
        this.displayNameCn = displayNameCn;
    }

    public String getDisplayNameEn() {
        return displayNameEn;
    }

    public void setDisplayNameEn(String displayNameEn) {
        this.displayNameEn = displayNameEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOtherAction() {
        return otherAction;
    }

    public void setOtherAction(String otherAction) {
        this.otherAction = otherAction;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
