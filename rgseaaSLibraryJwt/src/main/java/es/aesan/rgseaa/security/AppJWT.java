package es.aesan.rgseaa.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;



@SpringBootApplication
@ComponentScan(basePackages = {
        "es.aesan.rgseaa.service",
        "es.aesan.rgseaa.security"})
public class AppJWT  extends SpringBootServletInitializer implements WebApplicationInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppJWT.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppJWT.class, args);
    }


}
