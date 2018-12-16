package im.heart.shop.entity;//package im.heart.shop.entity;
//
//import java.util.Date;
//
//import javax.persistence.*;
//
//import lombok.Data;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.validator.constraints.Length;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import com.alibaba.fastjson.annotation.JSONField;
//
//import im.heart.core.entity.AbstractEntity;
//
///**
// *
// *
// * @作者： LKG
// * @功能说明：物流公司列表
// */
//@Entity
//@Table(name = "shopping_delivery_corp")
//@DynamicUpdate(true)
//@Data
//public class DeliveryCorp  implements AbstractEntity<String>{
//
//	private String code;// 代号
//	private String name;// 名称
//	private String url;// 网址
//	private Integer sort;// 排序
//
//	@Length(max = 10)
//	@Column(length = 10, name = "STATUS", nullable = false)
//	private String status = "";
//
//}
