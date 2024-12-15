package com.example.phoco;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class PhocoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhocoApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource) {
		return args -> {
			Connection connection = dataSource.getConnection();
		};
	}

}
