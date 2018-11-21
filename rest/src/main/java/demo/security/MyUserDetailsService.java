package demo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public final class MyUserDetailsService implements UserDetailsService {

  private static List<UserObject> users = new ArrayList();

  public MyUserDetailsService() {
    users.add(new UserObject("11", "11", "ROLE_ADMIN"));
    users.add(new UserObject("22", "22", "ROLE_USER"));
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws
      UsernameNotFoundException {
    Optional<UserObject> user = users.stream()
        .filter(u -> u.name.equals(username))
        .findAny();
    if (!user.isPresent()) {
      throw new UsernameNotFoundException("UserController "
          + "not found by name: " + username);
    }
    return toUserDetails(user.get());
  }

  private UserDetails toUserDetails(final UserObject userObject) {
    return User.withUsername(userObject.name)
        .password(userObject.password)
        .roles(userObject.role).build();
  }

  private static final class UserObject {
    private String name;
    private String password;
    private String role;

    private UserObject(final String name,
        final String password, final String role) {
      this.name = name;
      this.password = password;
      this.role = role;
    }
  }

}
