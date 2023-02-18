package com.iuh.backendkltn32.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iuh.backendkltn32.common.EVaiTro;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	
	 @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf()	
	        .disable()
	        .authorizeHttpRequests()
	        .requestMatchers("/api/xac-thuc/test", "/api/xac-thuc/dang-nhap").permitAll()
            .and()
            .authorizeHttpRequests().requestMatchers("/api/sinh-vien/**").authenticated()
	        .and()
	        .authorizeHttpRequests().requestMatchers("/api/quan-ly/**")
            .authenticated()
	        .and()
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	        .authenticationProvider(authenticationProvider)
	        .httpBasic();
	    http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	  }

}
