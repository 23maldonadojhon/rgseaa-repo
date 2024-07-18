package es.aesan.rgseaa.security.config;


import es.aesan.rgseaa.security.service.AuthProviderService;
import es.aesan.rgseaa.security.service.JwtAuthenticationEntryPoint;
import es.aesan.rgseaa.security.service.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class WebSecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final AuthProperties properties;
    private final AuthProviderService authProviderService;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;

    @Autowired
    public WebSecurityConfig(
            AuthenticationConfiguration authenticationConfiguration,
            AuthProperties properties,
            AuthProviderService authProviderService,
            JwtAuthenticationEntryPoint jwtEntryPoint) {

        this.authenticationConfiguration = authenticationConfiguration;
        this.properties = properties;
        this.authProviderService = authProviderService;
        this.jwtEntryPoint = jwtEntryPoint;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.cors();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.httpBasic().disable();

        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);

        http.authorizeRequests()
                // .antMatchers(HttpMethod.POST, properties.getAuthEndpointLoginRequest()).permitAll()
                // .antMatchers(properties.getPublicEndpoints()).permitAll()
                // .antMatchers(properties.getStaticResourcesPath()).permitAll()
                .anyRequest().permitAll();

        http.addFilterBefore(createAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    private OncePerRequestFilter createAuthorizationFilter() {
        return new JwtAuthenticationFilter(authProviderService);
    }
}
