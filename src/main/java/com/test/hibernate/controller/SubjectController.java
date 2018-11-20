package com.test.hibernate.controller;

import com.test.hibernate.model.Subject;
import com.test.hibernate.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects/")
public final class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @GetMapping("/")
  ResponseEntity<List<Subject>> list() {
    List<Subject> subjects = subjectService.getAll();
    if (subjects.size() > 1) {
      return new ResponseEntity<>(subjects, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
