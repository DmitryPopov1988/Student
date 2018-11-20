package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import com.test.hibernate.repository.StudentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  @Override
  public List<Student> getAll() {
    return studentDao.getAll();
  }

  @Override
  public Student getById(long id) {
    return null;
  }

  @Override
  public long createStudent() {
    return 0;
  }

  @Override
  public long updateStudent(long id) {
    return 0;
  }

  @Override
  public long deleteStudentBuId() {
    return 0;
  }
}
