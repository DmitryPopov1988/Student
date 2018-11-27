package rest.controller;

import rest.service.UserService;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping("/user/me")
  private Principal getPrincipal(final Principal principal) {
    return principal;
  }

  @RequestMapping("/exit")
  public void exit(final HttpServletRequest request,
      final HttpServletResponse response) {
    new SecurityContextLogoutHandler().logout(request, null, null);
    try {
      response.sendRedirect(request.getHeader("referer"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
