package com.school_server.config;

import com.school_server.security.AdminUserDetailsService;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;


@Configuration
@Import(SecurityConfig.class)
@EnableWebSecurity
public class logingConfig
{

    @Autowired
    AdminUserDetailsService userDetailsService;
    @Bean
    public AuthenticationManager authenticationmanager(AuthenticationConfiguration authconfigure) throws Exception{
        return authconfigure.getAuthenticationManager();
    }
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
       http.csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorize->authorize.requestMatchers(HttpMethod.GET,"/api/students/**").permitAll()
                       .requestMatchers(HttpMethod.DELETE,"/api/students/**").permitAll()
                       .requestMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
                       .requestMatchers("/api/students/update-student/**").hasAnyAuthority("ADMIN")
                       .requestMatchers("/api/students/save-student").hasAnyAuthority("ADMIN")
                       .anyRequest().authenticated());
        return http.build();
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}

