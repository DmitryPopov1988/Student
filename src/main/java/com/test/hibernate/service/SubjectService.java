package com.test.hibernate.service;

import com.test.hibernate.model.Subject;
import java.util.List;

public interface SubjectService {

  List<Subject> getAll();
  Subject getById(long id);
  long createSubject();
  long updateSubject(long id);
  long deleteSubjectById();

}
