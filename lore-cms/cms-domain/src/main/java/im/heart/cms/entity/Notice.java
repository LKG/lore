package im.heart.cms.entity;


import com.alibaba.fastjson.annotation.JSONField;
import im.heart.core.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;


/**
 * 
 * @作者： LKG  
 * @功能说明：宣传图片信息
 */
@Entity
@Table(name = "cms_notice")
@DynamicUpdate()
@DynamicInsert()
@Data
public class Notice implements AbstractEntity<BigInteger>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5812513752963613301L;

	/**
	 * 
	 * 
	 * @作者： LKG
	 * @功能说明：项目状态
	 */
	public enum NoticeStatus{
		pending,enabled,disabled
	}
	public enum NoticeType{
		image,music,video,unknown
	}
	public enum NoticeGroup{
		index,unknown
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 32, name = "NOTICE_ID", nullable = false, unique = true, updatable = false)
	private BigInteger noticeId;
	
	
	@NotNull
	@Length(max = 64)
	@Column(length = 64, name = "NOTICE_TITLE", nullable = false)
	private String noticeTitle ;
	
	@NotNull
	@Length(max = 10)
	@Column(length = 10, name = "NOTICE_TYPE", nullable = false)
	private String noticeType=NoticeType.image.toString() ;
	
	@Length(max = 15)
	@Column(length = 15, name = "NOTICE_GROUP")
	
	private String noticeGroup=NoticeGroup.index.toString() ;

	/**
	 * //活动简介
	 */
	@NotNull
	@Length(max = 128)
	@Column(length = 128, name = "NOTICE_WORD", nullable = false)
	private String noticeWord ;

	@NotNull
	@Column(length = 10, name = "NOTICE_SORT", nullable = false)
	private Integer noticeSort;
	
	
	@Length(max = 10)
	@Column(length = 10, name = "STATUS", nullable = false)
	private String status ;

	/**
	 * //活动展示宣传图片视频地址
	 */
	@NotNull
	@Length(max = 256)
	@Column(length = 256, name = "NOTICE_ADDR", nullable = false)
	private String noticeAddr ;

	/**
	 * 活动跳转路径
	 */
	@Length(max = 256)
	@URL
	@Column(length = 256, name = "NOTICE_URL")
	private String noticeUrl="" ;
	
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

	/**
	 * //活动描述信息
	 */
	@Length(max = 512)
	@Column(length = 512, name = "NOTICE_DESC")
	private String noticeDesc;

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