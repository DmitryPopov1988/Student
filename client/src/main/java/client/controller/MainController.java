package client.controller;

import client.service.UserService;
import client.model.Student;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
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
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream()
        .filter(student -> student.getName()
        .equals(principal.getName())).collect(
        Collectors.toList());
    model.addAttribute("students", sortedList);
    model.addAttribute("principal", principal.getName());
    return "main";
  }

}
