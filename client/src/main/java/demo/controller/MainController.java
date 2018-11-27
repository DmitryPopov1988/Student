package demo.controller;

import demo.model.Student;
import demo.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  private static List<String> strings = new ArrayList<>();
  static {
    strings.add("111");
    strings.add("222");
  }

  @Autowired
  private UserService userService;

  @GetMapping("/main")
  public String user(final Model model, final Principal principal,
      HttpServletRequest request, HttpSession httpSession,
      HttpServletResponse response) {
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream().filter(student -> student.getName()
        .equals(principal.getName())).collect(
        Collectors.toList());
    model.addAttribute("students", sortedList);
    model.addAttribute("principal", principal.getName());
    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      System.out.println(key + "  " + value);
    }
    strings.stream().forEach(s -> System.out.println(s));
    System.out.println(httpSession.getCreationTime());
    return "main";
  }

  @GetMapping("/main1")
  public String efef(final Model model, HttpSession httpSession) {
    strings.add("333");
    httpSession.setAttribute("hello world", strings);
    return "main";
  }



}
