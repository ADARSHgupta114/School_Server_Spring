package com.school_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class logingConfig
{
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            List<UserDetails> users = new ArrayList<>();
            users.add(User.withDefaultPasswordEncoder()
                    .username("Adarsh")
                    .password("password")
                    .roles("USER")
                    .build());
            return new InMemoryUserDetailsManager(users);
        }
}
