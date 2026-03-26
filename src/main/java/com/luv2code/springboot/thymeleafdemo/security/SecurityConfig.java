package com.luv2code.springboot.thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user1 = User.builder()
                .username("user")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password("{noop}1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config -> config
                .requestMatchers("/employees/list").hasAnyRole("EMPLOYEE", "ADMIN")
                .requestMatchers("/employees/showFormForAdd").hasRole("ADMIN")
                .requestMatchers("/employees/showFormForUpdate").hasRole("ADMIN")
                .requestMatchers("/employees/delete").hasRole("ADMIN")
                .requestMatchers("/employees/save").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        http.formLogin(form -> form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
        );

        http.logout(logout -> logout
                .logoutSuccessUrl("/showMyLoginPage")
                .permitAll()
        );

        http.exceptionHandling(config ->
                config.accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}