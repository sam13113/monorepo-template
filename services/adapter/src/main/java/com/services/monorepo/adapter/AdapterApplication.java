package com.services.monorepo.adapter;

import com.services.monorepo.domain.ApplicationReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main class.
 * */
@SpringBootApplication
@ComponentScan(basePackageClasses = {ApplicationReference.class}, basePackages = {"com.services.monorepo"})
@EnableWebMvc
@EnableConfigurationProperties
@EnableMongoRepositories(basePackageClasses = {AdapterApplication.class})
public class AdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
	}

}
