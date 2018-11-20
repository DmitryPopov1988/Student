package com.test.hibernate.repository;

import com.test.hibernate.model.Subject;
import java.util.List;

public interface SubjectDao {

  List<Subject> getAll();
  Subject getById(long id);
  long createSubject();
  long updateSubject(long id);
  long deleteSubjectById();

}