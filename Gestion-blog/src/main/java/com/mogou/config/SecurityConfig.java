package com.mogou.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactivation CSRF pour API REST
                .headers(headers -> headers
                        .contentSecurityPolicy(csp -> csp.policyDirectives("script-src 'self' 'unsafe-inline' https://cdn.tailwindcss.com https://cdn.jsdelivr.net;"))
                )
                .authorizeHttpRequests(auth -> auth
                        // Ressources statiques (CSS, JS, images)
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        // Accès public pour les APIs de lecture (GET)
                        .requestMatchers(HttpMethod.GET, "/api/articles/**").permitAll()
                        // Accès public pour les pages web
                        .requestMatchers(HttpMethod.GET, "/articles/**", "/swagger-ui/**", "/v3/api-docs/**", "/test-tailwind").permitAll()
                        // Accès admin pour les actions d'écriture (POST, PUT, DELETE)
                        .requestMatchers("/api/**", "/articles/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()); // Utilise le formulaire de login par défaut de Spring

        return http.build();
    }
}