package client.controller;

import client.service.UserService;
import client.model.Student;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public final class MainController {

  @Autowired
  private UserService userService;
  private static String studentName;
  private static String studentLastName;

  @GetMapping("/main")
  public String user(final Model model, final Principal principal) {
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream().distinct()
        .filter(student -> student.getName()
        .equals(principal.getName().replaceAll(" .*", ""))).collect(
        Collectors.toList());
    Student student = sortedList.get(0);
    studentName = student.getName();
    studentLastName = studentLastName;
    model.addAttribute("students", sortedList);
    model.addAttribute("principal", studentName);
    model.addAttribute("image", student.generateBase64Image());
    return "main";
  }

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") final MultipartFile file,
      final Principal principal) throws IOException {
    byte[] bytes = file.getBytes();
    List<Student> students = userService.getAll();
    List<Student> sortedList = students.stream().distinct()
        .filter(student -> student.getName()
            .equals(principal.getName().replaceAll(" .*", "")))
        .collect(
            Collectors.toList());
    Student student = sortedList.get(0);
    student.setImage(bytes);
    userService.updateStudent(student);
    return "redirect:/main";
  }

}
