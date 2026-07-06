package com.skillmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.skillmanager.security.jwt.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth

                    // Public
                    .requestMatchers("/api/auth/**").permitAll()

                    // Admin Only
                    .requestMatchers(
                            "/api/users/**",
                            "/api/roles/**"
                    ).hasRole("ADMIN")

                    // Admin + Manager
                    .requestMatchers(
                            "/api/projects/**",
                            "/api/resource-requests/**",
                            "/api/dashboard/**"
                    ).hasAnyRole("ADMIN", "MANAGER")

                    // All authenticated users
                    .requestMatchers(
                            "/api/employees/**",
                            "/api/skills/**",
                            "/api/employee-skills/**",
                            "/api/allocations/**"
                    ).authenticated()

                    .anyRequest().authenticated()
            )

            .httpBasic(Customizer.withDefaults());

        http.addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }
}