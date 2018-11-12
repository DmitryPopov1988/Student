package com.test.hibernate.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends
    WebSecurityConfigurerAdapter {

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .permitAll();
//        .authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .antMatchers("/", "/login")
//        .hasAnyRole("ANONYMOUS", "ADMIN")
//        .and()
//        .formLogin()
//        .permitAll();
  }

  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws
      Exception {
    auth
        .inMemoryAuthentication()
        .withUser("11")
        .password("{noop}11")
        .roles("ADMIN");
  }

}
