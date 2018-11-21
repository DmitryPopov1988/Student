package hibernate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends
    AuthorizationServerConfigurerAdapter {

  @Autowired
  private TokenStore tokenStore;
  @Autowired
  private UserApprovalHandler userApprovalHandler;
  @Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients)
      throws Exception {
    BCryptPasswordEncoder encoder = passwordEncoder();
    clients
        .inMemory()
        .withClient("my-trusted-client")
        .authorizedGrantTypes("client_credentials", "password", "refresh_token")
        .authorities("ROLE_ADMIN", "ROLE_USER")
        .scopes("read-write")
        .secret("secret");
  }

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints)
      throws Exception {
    endpoints
        .authenticationManager(authenticationManager);
  }

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer oauthServer)
      throws Exception {
    oauthServer.realm("/**");
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
