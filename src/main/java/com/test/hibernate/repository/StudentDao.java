package com.test.hibernate.repository;

import com.test.hibernate.model.Student;
import java.util.List;

public interface StudentDao {

  long save(Student student);
  Student get(long id);
  List<Student> list();
  void update(long id, Student student);
  void delete(long id);

}
