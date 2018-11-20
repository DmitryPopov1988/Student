package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import java.util.List;

public interface StudentService {

  List<Student> getAll();
  Student getById(long id);
  long createStudent(Student student);
  long updateStudent(Student student);
  long deleteStudentById(long id);

}
