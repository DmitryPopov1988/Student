package com.test.hibernate.repository;

import com.test.hibernate.model.Student;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public final class StudentDaoImpl implements StudentDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public long save(final Student student) {
    sessionFactory.getCurrentSession().save(student);
    return student.getId();
  }

  @Override
  public Student get(final long id) {
    return sessionFactory.getCurrentSession().get(Student.class, id);
  }

  @Override
  public List<Student> list() {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Student> criteriaQuery = criteriaBuilder
        .createQuery(Student.class);
    Root<Student> root = criteriaQuery.from(Student.class);
    criteriaQuery.select(root);
    Query<Student> query = session.createQuery(criteriaQuery);
    return query.getResultList();
  }

  @Override
  public void update(final long id, final Student book) {
    Session session = sessionFactory.getCurrentSession();
    Student student = session.byId(Student.class).load(id);
    student.setName(book.getName());
    student.setAge(book.getAge());
    session.flush();
  }

  @Override
  public void delete(final long id) {
    Session session = sessionFactory.getCurrentSession();
    Student student = session.byId(Student.class).load(id);
    session.delete(student);
  }

}
