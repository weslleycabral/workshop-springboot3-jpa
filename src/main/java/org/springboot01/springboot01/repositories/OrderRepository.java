package org.springboot01.springboot01.repositories;

import org.springboot01.springboot01.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
