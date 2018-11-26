package demo.controller;

import static java.util.Arrays.asList;

import demo.service.UserService;
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.http.Cookie;
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
    model.addAttribute("students", userService.getAll());
    model.addAttribute("principal", principal.getName());
    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      System.out.println(key + "  " + value);
    }
    strings.stream().forEach(s -> System.out.println(s));
    Cookie cookie = new Cookie("helloworld", "lalalala");
    response.addCookie(cookie);
    return "main";
  }

  @GetMapping("/main1")
  public String efef(final Model model, HttpSession httpSession) {
    strings.add("333");
    httpSession.setAttribute("hello world", strings);
    return "main";
  }



}
