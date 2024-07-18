package es.aesan.rgseaa.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan(basePackages = "es.aesan.rgseaa.model.entity")
@EnableJpaRepositories(basePackages = "es.aesan.rgseaa.service.repository")
@ComponentScan(basePackages = {
        "es.aesan.rgseaa.model",
        "es.aesan.rgseaa"})
public class AppService
{

    public static void main(String[] args) {
        SpringApplication.run(AppService.class, args);
    }

}
