package rest.security;

import rest.model.User;
import rest.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetails implements UserDetailsService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(final String username) throws
      UsernameNotFoundException {
    try {
      User user = userDao.getUserByName(username);
      UserBuilder builder = null;
      builder = org.springframework.security.core
          .userdetails.User.withUsername(user.getStudent()
              .getName() + " " + user.getStudent().getLastName());
      builder.password(new BCryptPasswordEncoder()
          .encode(user.getPassword()));
      builder.roles(user.getRole());
      return builder.build();
    } catch (Throwable exc) {
      throw new UsernameNotFoundException("User not found");
    }
  }
}
