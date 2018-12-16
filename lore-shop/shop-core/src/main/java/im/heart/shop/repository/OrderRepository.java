package im.heart.shop.repository;

import im.heart.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

public interface OrderRepository extends JpaRepository<Order, BigInteger>,JpaSpecificationExecutor<Order> {

}
