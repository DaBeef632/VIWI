package org.perscholas.viwi.config;

import org.perscholas.viwi.DAO.BottleRepository;
import org.perscholas.viwi.DAO.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class BottleConfig {
    @Bean
    CommandLineRunner commandLineRunner(BottleRepository bottleRepository){
        return args -> {


        };

    }
}
