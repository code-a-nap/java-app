package com.vulnerable.application.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests().anyRequest().authenticated()
                                .and()
                                .httpBasic();

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                                .username("john")
                                .password(System.getenv("USERPWD"))
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(user);
        }
}
