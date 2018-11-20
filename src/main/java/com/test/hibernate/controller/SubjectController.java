package com.test.hibernate.controller;

import com.test.hibernate.model.Subject;
import com.test.hibernate.service.SubjectService;
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

  @GetMapping("{id}")
  ResponseEntity<Subject> get(@PathVariable final long id) {
    Subject student = subjectService.getById(id);
    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/")
  ResponseEntity<Long> save(@RequestBody final Subject subject) {
    long response = subjectService.createSubject(subject);
    if (response > 0) {
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("{id}")
  ResponseEntity<Void> update(@PathVariable final long id,
      @RequestBody final Subject subject) {
    subject.setId(id);
    long response = subjectService.updateSubject(subject);
    if (response > 0) {
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> delete(@PathVariable final long id) {
    long response = subjectService.deleteSubjectById(id);
    if (response > 0) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
