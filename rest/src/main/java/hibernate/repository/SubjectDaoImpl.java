package hibernate.repository;

import hibernate.model.Subject;
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
  public Subject getById(final long id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Subject subject = session.get(Subject.class, id);
    session.getTransaction().commit();
    return subject;
  }

  @Override
  public long createSubject(final Subject subject) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(subject);
    session.getTransaction().commit();
    return subject.getId();
  }

  @Override
  public long updateSubject(final Subject subject) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.beginTransaction();
      session.saveOrUpdate(subject);
      session.getTransaction().commit();
      return subject.getId();
    } catch (Throwable exc) {
      return 0;
    }
  }

  @Override
  public long deleteSubjectById(final long id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Subject subject = session.get(Subject.class, id);
    if (subject == null) {
      return 0;
    }
    session.delete(subject);
    session.getTransaction().commit();
    return subject.getId();
  }
}
