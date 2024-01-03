package org.springboot01.springboot01.repositories;

import org.springboot01.springboot01.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
