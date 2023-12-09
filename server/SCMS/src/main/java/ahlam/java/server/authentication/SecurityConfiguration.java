package ahlam.java.server.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;


import ahlam.java.server.jwt.TokenService;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private AuthProvider authenticationProvider;
    @Autowired
    private TokenService tokenService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors() // Enable CORS
                .and()
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/users/register").permitAll()
                                .requestMatchers("/students").permitAll()
                                .requestMatchers("/courses").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/students").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .formLogin()
                .successHandler(new CustomAuthSuccessHandler(tokenService));


        http.authenticationProvider(authenticationProvider);

        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("http://localhost:3000"); 
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}