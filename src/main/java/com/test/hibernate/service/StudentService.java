package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import java.util.List;

public interface StudentService {

  long save(Student book);
  Student get(long id);
  List<Student> list();
  void update(long id, Student book);
  void delete(long id);

}
