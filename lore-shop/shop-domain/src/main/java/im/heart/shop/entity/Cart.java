package im.heart.shop.entity;

import im.heart.core.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * 
 * 
 * @作者： LKG
 * @功能说明：购物车实体类
 */
@Entity
@Table(name = "shopping_cart")
@DynamicUpdate()
@DynamicInsert()
@Data
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "shopping_cart_sequence")
public class Cart  implements AbstractEntity<BigInteger> {
	@Id
	@Column(length = 32, name = "CART_ID", nullable = false, unique = true, updatable = false)
	private BigInteger 	cartId;//购物车Id
	private BigInteger userId;//用户Id
	private String userName;//用户账号
	/**
	 * 是否逻辑删除 N:否 Y:是
	 */
	private Boolean isDeleted;
	private String 	couponIds;//优惠券编号列表
	private String 	itemIds;
}

