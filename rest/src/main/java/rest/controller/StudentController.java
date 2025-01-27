package rest.controller;

import rest.model.Student;
import rest.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/")
public final class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/")
  ResponseEntity<List<Student>> list() {
    List<Student> students = studentService.getAll();
    if (students.size() > 1) {
      return new ResponseEntity<>(students, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("{id}")
  ResponseEntity<Student> get(@PathVariable final long id) {
    Student student = studentService.getById(id);
    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/")
  ResponseEntity<Long> save(@RequestBody final Student student) {
    long response = studentService.createStudent(student);
    if (response > 0) {
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("{id}")
  ResponseEntity<Void> update(@PathVariable final long id,
      @RequestBody final Student student) {
    student.setId(id);
    long response = studentService.updateStudent(student);
    if (response > 0) {
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> delete(@PathVariable final long id) {
    long response = studentService.deleteStudentById(id);
    if (response > 0) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}


