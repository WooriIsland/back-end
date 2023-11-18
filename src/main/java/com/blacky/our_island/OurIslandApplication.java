package com.blacky.our_island;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OurIslandApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurIslandApplication.class, args);
    }

}
