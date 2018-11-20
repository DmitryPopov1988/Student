package com.test.hibernate.repository;

import com.test.hibernate.model.Student;
import java.util.List;

public interface StudentDao {

  List<Student> getAll();
  Student getById(long id);
  long createStudent();
  long updateStudent(long id);
  long deleteStudentBuId();

}
