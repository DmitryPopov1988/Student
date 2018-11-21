package hibernate.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements
    AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    System.out.println(authentication.getPrincipal().toString());
    System.out.println(authentication.getCredentials().toString());
    System.out.println(authentication.getAuthorities().toString());
    System.out.println(authentication.getDetails().toString());

    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }
}
