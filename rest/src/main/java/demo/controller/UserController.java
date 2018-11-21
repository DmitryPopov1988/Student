package demo.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserController {

  @GetMapping("/user/me")
  public Principal getPrincipal(final Principal principal) {
    return principal;
  }

}
