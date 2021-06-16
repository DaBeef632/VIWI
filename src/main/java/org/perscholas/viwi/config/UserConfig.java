package org.perscholas.viwi.config;

import org.perscholas.viwi.DAO.UserRepository;
import org.perscholas.viwi.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {

            User greg =  new User(
                    "Greg",
                    "greg.conti@gmail.com",
                    LocalDate.of(1985, Month.NOVEMBER, 17)
            );

            User mia =  new User(
                    "Mia",
                    "mia@gmail.com",
                    LocalDate.of(1993, Month.NOVEMBER, 17)
            );

            repository.saveAll(
                    List.of(greg, mia)
            );

        };
    }
}
