package es.aesan.rgseaa.security.config;


import es.aesan.rgseaa.util.Url;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class AuthProperties {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public String[] getPublicEndpoints() {
        return new String[]{
                "/api-docs/**",
                "/swagger-ui",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/**",
                "/swagger-ui.html",
                "/webjars/**",
                this.contextPath + Url.HOOKS + "/clave/auth/login_response",
                this.contextPath + Url.HOOKS + "/clave/auth/logout_response"
        };
    }

    public String[] getStaticResourcesPath() {
        return new String[]{
                "/",
                "/favicon.ico",
                "/**/*.json",
                "/**/*.xml",
                "/**/*.properties",
                "/**/*.woff2",
                "/**/*.woff",
                "/**/*.ttf",
                "/**/*.ttc",
                "/**/*.ico",
                "/**/*.bmp",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.jpeg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js"
        };
    }
}
