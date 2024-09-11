package com.abhi.prj.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.abhi.prj.customusers.CustomUserDetailsServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
	@Autowired
	private DataSource datasource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsServices();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();           //this bean is for password
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvideer() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/list_users").authenticated() // Allow access to login page
                //.antMatchers("/resources/**").permitAll()  // Allow access to static resources
                .anyRequest().permitAll()  // Require authentication for all other requests
                .and()
                .formLogin()
                	.usernameParameter("email")
                	.defaultSuccessUrl("/list_users")
                	.permitAll()
            .and()
            .logout().logoutSuccessUrl("/").permitAll();
        return http.build();
    }
	
}
