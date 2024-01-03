package org.springboot01.springboot01.config;

import org.springboot01.springboot01.entities.Category;
import org.springboot01.springboot01.entities.Order;
import org.springboot01.springboot01.entities.User;
import org.springboot01.springboot01.entities.enums.OrderStatus;
import org.springboot01.springboot01.repositories.CategoryRepository;
import org.springboot01.springboot01.repositories.OrderRepository;
import org.springboot01.springboot01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        var u1 = new User(null, "Maria Joaquina", "maria@gmail.com", "996111543", "123456");
        var u2 = new User(null, "Severino Arquino", "severino@gmail.com", "999890590", "487362");

        var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        var cat1 = new Category(null, "Electronics");
        var cat2 = new Category(null, "Books");
        var cat3 = new Category(null, "Computers");


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
