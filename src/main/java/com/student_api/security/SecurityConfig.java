package com.student_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager detailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(
                "SELECT user_name, password, enabled FROM members WHERE user_name=?"
        );

        userDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_name, role FROM permissions WHERE user_name=?"
        );
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("USER","ITI-OFFICER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("ITI-OFFICER","ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/students").hasAnyRole("ITI-OFFICER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
