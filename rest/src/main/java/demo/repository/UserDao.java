package demo.repository;

import demo.model.User;

public interface UserDao {

  User getUserByName(String username);

}
