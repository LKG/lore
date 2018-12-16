package im.heart.usercore.vo;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.usercore.entity.FrameRole;
import im.heart.usercore.entity.FrameRoleResource;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

public class FrameRoleVO extends FrameRole {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1248662944155577393L;
	@JSONField(serialize = false)
	private Date modifyTime;
	private List<FrameRoleResource> roleResources;
	public FrameRoleVO(FrameRole po){
		BeanUtils.copyProperties(po, this);
	}
	public List<FrameRoleResource> getRoleResources() {
		return roleResources;
	}
	public void setRoleResources(List<FrameRoleResource> roleResources) {
		this.roleResources = roleResources;
	}
	
}
