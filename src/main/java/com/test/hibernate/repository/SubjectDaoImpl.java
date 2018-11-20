package com.test.hibernate.repository;

import com.test.hibernate.model.Subject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDaoImpl implements SubjectDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Subject> getAll() {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    List<Subject> subjects = session
        .createQuery("from Subject").list();
    return subjects;
  }

  @Override
  public Subject getById(long id) {
    return null;
  }

  @Override
  public long createSubject() {
    return 0;
  }

  @Override
  public long updateSubject(long id) {
    return 0;
  }

  @Override
  public long deleteSubjectById() {
    return 0;
  }
}
