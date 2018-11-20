package com.test.hibernate.repository;

import com.test.hibernate.model.Student;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Student> getAll() {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    List<Student> students = session
        .createQuery("from Student").list();
    return students;
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
