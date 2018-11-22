package demo.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/main")
  public String user(final Model model, final Principal principal) {
    model.addAttribute("principal", principal.getName());
    return "main";
  }

}
