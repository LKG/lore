package im.heart.usercore.vo;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.usercore.entity.FrameRole;
import org.springframework.beans.BeanUtils;

import java.math.BigInteger;
import java.util.Date;

public class FrameUserRoleVO extends  FrameRole {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6662998853899204880L;

	@JSONField (serialize=false)
	private String roleDesc;
	
	@JSONField (serialize=false)
	private Date createTime;
	
	@JSONField (serialize=false)
	private Date modifyTime;
	
	private BigInteger userId;
	private String userName;
	
	private Boolean hasRole=Boolean.FALSE;
	public FrameUserRoleVO(FrameRole po){
		BeanUtils.copyProperties(po, this);
	}
	public Boolean getHasRole() {
		return hasRole;
	}
	public void setHasRole(Boolean hasRole) {
		this.hasRole = hasRole;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
