package hibernate.repository;

import hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public User getUserByName(final String username) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    User subject = session.get(User.class, username);
    session.getTransaction().commit();
    return subject;
  }

}
