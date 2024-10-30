package com.revature.P1Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.revature.models") //This tells Spring Boot to look for models package for DB entities
@ComponentScan("com.revature")
@EnableJpaRepositories("com.revature.daos") //This tells Spring Boot to look in the daos package for JPA repositories
public class P1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1DemoApplication.class, args);

	}

}
