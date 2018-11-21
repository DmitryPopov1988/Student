package hibernate.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ClientDetailsService clientDetailsService;
  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .anonymous()
        .disable()
        .authorizeRequests()
        .antMatchers("/oauth/token")
        .permitAll();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(final AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .withUser("aa")
        .password("aa")
        .roles("ROLE_ADMIN")
        .authorities("ROLE_ADMIN");
//        .jdbcAuthentication()
//        .dataSource(dataSource)
//        .usersByUsernameQuery("SELECT username, password, "
//            + "enabled FROM users WHERE username = ?")
//        .authoritiesByUsernameQuery("select username, authority "
//            + "from authorities where username=?")
//        .passwordEncoder(new BCryptPasswordEncoder());
  }

}
