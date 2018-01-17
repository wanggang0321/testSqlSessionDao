package com.test.role.entity;

import java.util.Date;

public class Role {
	
	private String roleID	;
	private String roleName	;
	private Date createtime	;
	private String revo	;
	private String portalType;
	private String level	;
	private String tenantid	;
	private String pubid	;
	
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getRevo() {
		return revo;
	}
	public void setRevo(String revo) {
		this.revo = revo;
	}
	public String getPortalType() {
		return portalType;
	}
	public void setPortalType(String portalType) {
		this.portalType = portalType;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTenantid() {
		return tenantid;
	}
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
	public String getPubid() {
		return pubid;
	}
	public void setPubid(String pubid) {
		this.pubid = pubid;
	}
	
}
