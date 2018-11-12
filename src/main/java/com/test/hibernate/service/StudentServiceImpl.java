package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import com.test.hibernate.repository.StudentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public final class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;


  @Override
  public long save(final Student student) {
    return studentDao.save(student);
  }

  @Override
  public Student get(final long id) {
    return studentDao.get(id);
  }

  @Override
  public List<Student> list() {
    return studentDao.list();
  }

  @Override
  public void update(final long id, final Student student) {
    studentDao.update(id, student);

  }

  @Override
  public void delete(final long id) {
    studentDao.delete(id);
  }

}
