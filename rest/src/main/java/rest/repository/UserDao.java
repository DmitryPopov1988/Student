package rest.repository;

import rest.model.User;
import java.util.List;

public interface UserDao {

  User getUserByName(String username);
  List<User> getAllUsers();

}
