package org.springboot01.springboot01.repositories;

import org.springboot01.springboot01.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
