package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import com.test.hibernate.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public Student save(final Student student) {
    return studentRepository.save(student);
  }

  public Student get(final long id) {
    return studentRepository.getOne(id);
  }

  public List<Student> list() {
    return studentRepository.findAll();

  }

  public Student update(final long id, final Student student) {
    Student oldStudent = studentRepository.getOne(id);
    if (oldStudent != null) {
      oldStudent.setAge(student.getAge());
      oldStudent.setName(student.getName());
    }
    return studentRepository.save(oldStudent);
  }

  public void delete(final long id) {
    studentRepository.deleteById(id);
  }

}
