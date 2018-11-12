package com.test.hibernate.controller;

import com.test.hibernate.model.Student;
import com.test.hibernate.service.StudentService;
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
@RequestMapping("/")
public final class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/")
  ResponseEntity<Long> save(@RequestBody final Student student) {
    Student response = studentService.save(student);
    return new ResponseEntity<>(response.getId(), HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  ResponseEntity<Student> get(@PathVariable final long id) {
    Student student = studentService.get(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @GetMapping("/")
  ResponseEntity<List<Student>> list() {
    List<Student> students = studentService.list();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @PutMapping("{id}")
  ResponseEntity<Void> update(@PathVariable final long id,
      @RequestBody final Student student) {
    studentService.update(id, student);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> delete(@PathVariable final long id) {
    studentService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
