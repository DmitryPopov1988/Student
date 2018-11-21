package demo.service;

import demo.model.Student;
import java.util.List;

public interface StudentService {

  List<Student> getAll();
  Student getById(long id);
  long createStudent(Student student);
  long updateStudent(Student student);
  long deleteStudentById(long id);

}
