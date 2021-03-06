package im.heart.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Boolean invoiceFlag;
    private BigInteger couponId;
    private BigInteger userId;
    private String buyerName;// 订单归属用户名称
    private String buyerMobile;// 订单归属用户电话号码
    private List<OrderItemDto> items;
}
