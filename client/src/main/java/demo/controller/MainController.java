package demo.controller;

import demo.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @Autowired
  private UserService userService;

  @GetMapping("/main")
  public String user(final Model model, final Principal principal) {
    model.addAttribute("students", userService.getAll());
    model.addAttribute("principal", principal.getName());
    return "main";
  }

}
