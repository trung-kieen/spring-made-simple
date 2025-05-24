package com.trung_kieen.hibernate_audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateAuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAuditApplication.class, args);
	}

}
