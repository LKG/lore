package im.heart.cms.entity;

import im.heart.core.entity.AbstractEntity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 
 * @作者： LKG
 * @功能说明：宣传图片信息
 */
@Entity
@Table(name = "dic_frame_image")
@DynamicUpdate()
@DynamicInsert()
@Data
public class FrameImage implements AbstractEntity<BigInteger> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2864825909067283477L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 32, name = "IMAGE_ID", nullable = false, unique = true, updatable = false)
	private BigInteger imageId;

	
	@Length(max = 32)
	@Column(length = 10, name = "RELATE_ID", nullable = false)
	private String relateId;


	@Length(max = 32)
	@Column(length = 10, name = "IMAGE_GROUP", nullable = false)
	private String imageGroup;

	@Length(max = 32)
	@Column(length = 10, name = "IMAGE_URL", nullable = false)
	private String imageUrl;

	@Length(max = 10)
	@Column(length = 10, name = "STATUS", nullable = false)
	private String status;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATE_TIME", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss", serialize = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "MODIFY_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyTime;
	// 活动描述信息
	@Length(max = 512)
	@Column(length = 512, name = "REMARK")
	private String remark;

	@Column(length = 32, name = "USER_ID", nullable = false, unique = true, updatable = false)
	private BigInteger userId;

	@Column(length = 512, name = "USER_NAME")
	private String userName;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
		modifyTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

}
