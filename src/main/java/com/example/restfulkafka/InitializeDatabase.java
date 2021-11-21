package com.example.restfulkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeDatabase {

    private static final Logger log = LoggerFactory.getLogger(InitializeDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            log.info("Preloading " + customerRepository.save(new Customer("Gerasimos", "Tsakalis", 34)));
            log.info("Preloading " + customerRepository.save(new Customer("John", "Doe", 50)));
            log.info("Preloading " + customerRepository.save(new Customer("Jack", "Smith", 38)));
        };
    }
}
