package hibernate.repository;

import hibernate.model.User;

public interface UserDao {

  User getUserByName(String username);

}
