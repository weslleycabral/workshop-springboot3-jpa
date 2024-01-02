package org.springboot01.springboot01.config;

import org.springboot01.springboot01.entities.User;
import org.springboot01.springboot01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        var user01 = new User(null, "Maria Joaquina", "maria@gmail.com", "996111543", "123456");
        var user02 = new User(null, "Severino Arquino", "severino@gmail.com", "999890590", "487362");

        userRepository.saveAll(Arrays.asList(user01,user02));
    }
}
