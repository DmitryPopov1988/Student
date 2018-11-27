package client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${authorization}/exit")
  private String logoutUrl;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/", "/static/images/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl(logoutUrl)
        .permitAll();
  }

}
