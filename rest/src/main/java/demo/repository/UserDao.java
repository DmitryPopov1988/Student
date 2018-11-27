package demo.repository;

import demo.model.User;
import java.util.List;

public interface UserDao {

  User getUserByName(String username);

  List<User> getAllUsers();

}
