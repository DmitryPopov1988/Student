package demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends
    AuthorizationServerConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer
      oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer
      clients) throws Exception {
    clients
        .inMemory()
        .withClient("SampleClientId")
        .secret(passwordEncoder.encode("secret"))
        .authorizedGrantTypes("refresh_token", "client_credentials",
            "authorization_code", "implicit")
        .authorities("ROLE_ADMIN", "ROLE_USER")
        .scopes("read", "write")
        .autoApprove(true)
        .redirectUris("http://localhost:8088/login");
  }

}
