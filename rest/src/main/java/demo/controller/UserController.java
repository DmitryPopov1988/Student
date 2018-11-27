package demo.controller;

import demo.model.User;
import demo.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/user/me")
  private Principal getPrincipal(final Principal principal) {
    return principal;
  }

  @GetMapping("/users/")
  private ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }
}
