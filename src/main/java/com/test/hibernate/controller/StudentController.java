package com.test.hibernate.controller;

import com.test.hibernate.model.Student;
import com.test.hibernate.model.Subject;
import com.test.hibernate.repository.StudentDaoImpl;
import com.test.hibernate.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

  @GetMapping("/")
  ResponseEntity<List<Student>> list() {
    List<Student> students = studentService.getAll();
    if (students.size() > 1) {
      return new ResponseEntity<>(students, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

//  @GetMapping("{id}")
//  ResponseEntity<Student> get(@PathVariable final long id,
//      final HttpServletResponse response) {
//    Student student = studentDaoImpl.get(id);
//    if (student != null) {
//      return new ResponseEntity<>(student, HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }
//
//  @PostMapping("/")
//  ResponseEntity<Long> save(@RequestBody final Student student) {
//    List<Subject> subjects = new ArrayList<Subject>();
//      subjects.add(new Subject("TEST"));
//      student.setSubjects(subjects);
//    Student response = studentDaoImpl.save(student);
//    if (response != null) {
//      return new ResponseEntity<>(response.getId(), HttpStatus.CREATED);
//    } else {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//  }
//
//  @PutMapping("{id}")
//  ResponseEntity<Void> update(@PathVariable final long id,
//      @RequestBody final Student student) {
//    Student student1 = studentDaoImpl.update(id, student);
//    if (student1 != null) {
//      return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    } else {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//  }
//
//  @DeleteMapping("{id}")
//  ResponseEntity<Void> delete(@PathVariable final long id) {
//    try {
//      studentDaoImpl.delete(id);
//      return new ResponseEntity<>(HttpStatus.OK);
//    } catch (EmptyResultDataAccessException exception) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//  }

}
