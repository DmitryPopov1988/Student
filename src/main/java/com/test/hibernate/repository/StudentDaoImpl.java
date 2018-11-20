package com.test.hibernate.repository;

import com.test.hibernate.model.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.ExceptionMapperStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    session.getTransaction().commit();
    return students;
  }

  @Override
  public Student getById(final long id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Student student = session.get(Student.class, id);
    session.getTransaction().commit();
    return student;
  }

  @Override
  public long createStudent(final Student student) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(student);
    session.getTransaction().commit();
    return student.getId();
  }

  @Override
  public long updateStudent(final Student student) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.beginTransaction();
      session.saveOrUpdate(student);
      session.getTransaction().commit();
      return student.getId();
    } catch (Throwable exc) {
      return 0;
    }
  }

  @Override
  public long deleteStudentById(final long id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Student student = session.get(Student.class, id);
    if (student == null) {
      return 0;
    }
    session.delete(student);
    session.getTransaction().commit();
    return student.getId();
  }

}
