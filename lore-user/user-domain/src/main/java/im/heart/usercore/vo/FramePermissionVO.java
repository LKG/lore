package im.heart.usercore.vo;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.core.enums.Status;
import im.heart.usercore.entity.FramePermission;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class FramePermissionVO extends FramePermission {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3553390353178815126L;
	
	private Boolean isChecked = Boolean.FALSE;
	
	@JSONField(serialize = false)
	private String permissionDesc;
	@JSONField(serialize = false)
	private Date createTime;
	@JSONField(serialize = false)
	private Status status = Status.enabled;
	public FramePermissionVO(){
	}
	public FramePermissionVO(FramePermission po){
		BeanUtils.copyProperties(po, this);
	}
	public Boolean getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
