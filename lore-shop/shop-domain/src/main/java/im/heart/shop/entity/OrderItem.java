package im.heart.shop.entity;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.core.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 
 * @功能说明：商品订单项表
 * @作者 LKG
 */
@Entity
@Table(name = "shopping_order_item")
@DynamicUpdate()
@DynamicInsert()
@Data
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "shopping_order_item_sequence")
public class OrderItem implements AbstractEntity<BigInteger> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 32, name = "ITEM_ID", nullable = false, unique = true, updatable = false)
	private BigInteger itemId;

	@Column(length = 32, name = "ORDER_ID", nullable = false, updatable = false)
	private BigInteger orderId;// 订单号
	@Column(length = 32, name = "PROD_ID", nullable = false, updatable = false)
	private BigInteger prodId;// 商品货号
	@Column(length = 256, name = "PROD_NAME", nullable = false, updatable = false)
	private String prodName;// 商品名称

	@Column(name = "PROD_ORIGIN_PRICE", nullable = false, updatable = false)
	private BigDecimal prodOriginPrice;// 商品价格
	@Column(name = "PROD_QUANTITY", nullable = false, updatable = false)
	private Integer prodQuantity;// 商品数量

	@Column(name = "PROD_FINAL_PRICE", nullable = false, updatable = false)
	private BigDecimal prodFinalPrice;// 商品价格

	@Column(length = 32, name = "SELLER_ID", nullable = false)
	private BigInteger sellerId;//

	@Length(max = 128)
	@Column(length = 128, name = "SELLER_NAME", nullable = false)
	private String sellerName;//
	@Column(name = "PROD_URL", nullable = false, updatable = false)
	private String prodUrl;// 商品图片地址
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATE_TIME", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "MODI_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modiTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "SHIPPED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedTime;// 发货日期
	@PrePersist
	protected void onCreate() {
		createTime = new Date();
		modiTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modiTime = new Date();
	}
	@Version
	@Column( name = "VERSION")
	private Integer  version;
}
