package hibernate;

import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.hibernate"})
@EnableJpaAuditing
@RestController
public class RestApplication {

  @GetMapping("/user/me")
  public Principal getPrincipal(final Principal principal) {
    return principal;
  }


  public static void main(final String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }

}


