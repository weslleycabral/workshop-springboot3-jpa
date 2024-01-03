package org.springboot01.springboot01.repositories;

import org.apache.juli.logging.Log;
import org.springboot01.springboot01.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
