package com.demo.base.security.entity;

import java.io.Serializable;
import java.util.List;

public class SysResources implements Serializable {
    
    private String resourceId;

    private String resourceName;

    private String resourceDesc;

    private String resourceType;

    private String resourceUrl;

    private String parentId;

    private String orderNum;

    private String iconName;

    private List<SysResources> child;
    private static final long serialVersionUID = 1L;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    public List<SysResources> getChild() {
        return child;
    }

    public void setChild(List<SysResources> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "SysResources [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceDesc="
                + resourceDesc + ", resourceType=" + resourceType + ", resourceUrl=" + resourceUrl + ", parentId="
                + parentId + ", orderNum=" + orderNum + ", iconName=" + iconName + ", child=" + child + "]";
    }
    @Override
    public int hashCode() {
        Integer i = 0;
        for(Character c:resourceId.toCharArray()){
            i+=c;
        }
        return i;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SysResources) {
            SysResources r = (SysResources) obj;
            if(r.getResourceId().equals(this.resourceId)){
                return true;
            }
        }
        return false;
    }
}