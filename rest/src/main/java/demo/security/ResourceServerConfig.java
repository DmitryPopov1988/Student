package demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(ResourceServerConfig.MINUS_TWENTY)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  public static final int MINUS_TWENTY = -20;

  @Override
  protected void configure(final HttpSecurity http) throws
      Exception {
    http.requestMatchers()
        .antMatchers("/login", "/oauth/authorize")
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll();
  }

  @Override
  protected void configure(final AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("john")
        .password(passwordEncoder().encode("123"))
        .roles("USER");
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
