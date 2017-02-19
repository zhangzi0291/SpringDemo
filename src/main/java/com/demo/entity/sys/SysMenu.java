package com.demo.entity.sys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SysMenu implements Serializable {
    private BigDecimal id;

    private String menuName;

    private BigDecimal menuPid;

    private String menuIcon;

    private String menuUrl;

    private BigDecimal menuOrder;
    
    private List<SysMenu> child;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public BigDecimal getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(BigDecimal menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public BigDecimal getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(BigDecimal menuOrder) {
        this.menuOrder = menuOrder;
    }

	public List<SysMenu> getChild() {
		return child;
	}

	public void setChild(List<SysMenu> child) {
		this.child = child;
	}
    
}