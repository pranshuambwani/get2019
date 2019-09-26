package com.metacube.EADSession13Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EadSession13AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EadSession13AssignmentApplication.class, args);
	}

}
