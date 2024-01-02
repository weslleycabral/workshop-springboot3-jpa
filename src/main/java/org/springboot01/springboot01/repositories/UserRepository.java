package org.springboot01.springboot01.repositories;

import org.springboot01.springboot01.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
