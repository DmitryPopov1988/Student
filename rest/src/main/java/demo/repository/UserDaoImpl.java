package demo.repository;

import demo.model.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public User getUserByName(final String username) throws
      EmptyResultDataAccessException {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<User> criteria = builder.createQuery(User.class);
    Root<User> root = criteria.from(User.class);
    criteria.select(root).where(builder.equal(root.get("username"),
        username));
    Query<User> query = session.createQuery(criteria);
    return query.getSingleResult();
  }

}
