package rest.service;

import rest.model.User;
import java.util.List;

public interface UserService {

  User findByName(String name);

  List<User> getAllUsers();

}
