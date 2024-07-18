package es.aesan.rgseaa.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.WebApplicationInitializer;


@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {
		"es.aesan.rgseaa.service",
		"es.aesan.rgseaa.rest.controller"})
public class AppRest extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppRest.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AppRest.class, args);
	}

}
