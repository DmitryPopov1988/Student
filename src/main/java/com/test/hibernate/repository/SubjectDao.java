package com.test.hibernate.repository;

import com.test.hibernate.model.Subject;
import java.util.List;

public interface SubjectDao {

  List<Subject> getAll();
  Subject getById(long id);
  long createSubject(Subject subject);
  long updateSubject(Subject subject);
  long deleteSubjectById(long id);

}
