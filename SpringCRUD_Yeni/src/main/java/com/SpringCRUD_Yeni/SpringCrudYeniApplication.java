package com.SpringCRUD_Yeni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"controller","service"})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class SpringCrudYeniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudYeniApplication.class, args);
	}

}
