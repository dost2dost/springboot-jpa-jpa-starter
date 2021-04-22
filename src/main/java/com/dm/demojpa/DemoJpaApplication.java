package com.dm.demojpa;

import com.dm.demojpa.model.Users;
import com.dm.demojpa.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication()

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.dm.demojpa.repository","com.dm.demojpa.services"})
public class DemoJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

}
