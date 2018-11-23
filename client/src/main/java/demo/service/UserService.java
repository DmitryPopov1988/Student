package demo.service;

import demo.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  @Autowired
  private OAuth2RestOperations restTemplate;

  public List<Student> getAll() {
    ResponseEntity<List<Student>> entity = restTemplate
        .exchange("http://localhost:8090/auth/students/", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Student>>() {
        });
    List<Student> students = entity.getBody();
    return students;
  }

}