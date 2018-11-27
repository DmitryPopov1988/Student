package demo.service;

import demo.model.User;
import demo.repository.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public User findByName(final String name) {
    return userDao.getUserByName(name);
  }

  @Override
  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }
}
