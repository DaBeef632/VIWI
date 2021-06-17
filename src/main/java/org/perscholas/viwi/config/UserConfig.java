package org.perscholas.viwi.config;

import com.github.javafaker.Faker;
import org.perscholas.viwi.DAO.UserRepository;
import org.perscholas.viwi.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {

            Faker faker = new Faker();
            for (int i = 0; i<=20; i++){
                long minDay = LocalDate.of(1921, 1, 1).toEpochDay();
                long maxDay = LocalDate.of(1999, 12, 31).toEpochDay();
                long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@gmail.com", firstName, lastName);
                LocalDate dob = LocalDate.ofEpochDay(randomDay);
                User user = new User (
                        firstName,
                        lastName,
                        email,
                        dob
                );
                userRepository.save(user);
            }

        };
    }


}
