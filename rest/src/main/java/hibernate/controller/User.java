package hibernate.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

  @GetMapping("/user/me")
  public Principal getPrincipal(final Principal principal) {
    return principal;
  }

}
