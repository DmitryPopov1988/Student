package demo.controller;

import demo.service.UserService;
import java.security.Principal;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @Autowired
  private UserService userService;

  @GetMapping("/main")
  public String user(final Model model, final Principal principal, HttpServletRequest request) {
    model.addAttribute("students", userService.getAll());
    model.addAttribute("principal", principal.getName());
    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      System.out.println(key + "  " + value);
    }
    return "main";
  }

}
