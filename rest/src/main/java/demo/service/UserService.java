package demo.service;

import demo.model.User;
import java.util.List;

public interface UserService {

  User findByName(String name);

  List<User> getAllUsers();

}
