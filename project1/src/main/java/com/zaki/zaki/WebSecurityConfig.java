package com.zaki.zaki;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // requests ByRole authentication
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .httpBasic()
            .and().authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/vouchers/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/vouchers").hasRole("ADMIN")
                .anyRequest().authenticated()
            );
        return http.build();
    }

    
    // // default security configuration
    // @Bean
    // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.formLogin();
    //     http.authorizeHttpRequests().anyRequest().authenticated();
    //     return http.build();
    // }
    

    // // allow all requests without authentication
    // @Bean
    // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    //     return http.build();
    // }
}
