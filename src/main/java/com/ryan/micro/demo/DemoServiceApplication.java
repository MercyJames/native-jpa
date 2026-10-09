package com.ryan.micro.demo;

import com.ryan.micro.demo.entity.User;
import com.ryan.micro.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@Slf4j
public class DemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setUserId("James");
            user.setRealityName("James.K.Trump");
            log.info("【】>>>> {}", userRepository.save(user));
            System.exit(0);
        };
    }
}
