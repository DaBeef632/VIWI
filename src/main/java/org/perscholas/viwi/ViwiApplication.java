package org.perscholas.viwi;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ViwiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViwiApplication.class, args);

	}

}
