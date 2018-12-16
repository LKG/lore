package im.heart.shop.entity;

import im.heart.core.entity.AbstractEntity;

import java.math.BigInteger;

/**
 * 
 * @功能说明：优惠券实体类
 * @作者 LKG
 */
public class Coupon  implements AbstractEntity<BigInteger> {

	private String couponId;// 优惠券编号
	private String userId;// 用户Id
	private String userName;// 用户账号
}
