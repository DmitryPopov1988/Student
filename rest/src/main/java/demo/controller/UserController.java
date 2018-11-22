package demo.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class UserController {

  @GetMapping("/user/me")
  private Principal getPrincipal(final Principal principal) {
    return principal;
  }

}
