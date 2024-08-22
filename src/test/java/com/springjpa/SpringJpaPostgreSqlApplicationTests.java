package com.springjpa;

import com.springjpa.repo.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
		properties = {
				"management.endpoint.health.show-details=always",
				"spring.datasource.url=jdbc:tc:postgresql:16.4-alpine-3.40:///shinobiDB"
		},
		webEnvironment = RANDOM_PORT
)
public class SpringJpaPostgreSqlApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	void deleteAll() {
		customerRepository.deleteAll();
	}

}
