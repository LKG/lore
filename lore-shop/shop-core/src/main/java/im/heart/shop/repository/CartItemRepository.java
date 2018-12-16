package im.heart.shop.repository;

import im.heart.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

public interface CartItemRepository extends JpaRepository<CartItem, BigInteger>,JpaSpecificationExecutor<CartItem> {

}
