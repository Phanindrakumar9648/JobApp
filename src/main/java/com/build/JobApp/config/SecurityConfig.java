package com.build.JobApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // API security: Basic Auth only
    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/jobs").hasAnyRole("ADMIN", "VIEWER")
                .antMatchers("/api/jobs/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Disable CSRF for API
        return http.build();
    }

    // Web UI security: form login
    @Bean
    @Order(2)
    public SecurityFilterChain uiSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/css/**").permitAll()
                .antMatchers("/addjob", "/submitjob").hasRole("ADMIN")
                .antMatchers("/viewjobs").hasAnyRole("ADMIN", "VIEWER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll() // Default Spring login page
                .and()
                .logout().permitAll();
        return http.build();
    }

    // In-memory users with BCrypt passwords
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN") // ROLE_ADMIN
                .build();

        UserDetails viewer = User.withUsername("viewer")
                .password(passwordEncoder.encode("viewer123"))
                .roles("VIEWER") // ROLE_VIEWER
                .build();

        return new InMemoryUserDetailsManager(admin, viewer);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
