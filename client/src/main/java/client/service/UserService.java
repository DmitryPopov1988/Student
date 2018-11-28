package client.service;

import client.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private OAuth2RestOperations restTemplate;
  @Value("${authorization}/students/")
  private String studentsUrl;

  public List<Student> getAll() {
    ResponseEntity<List<Student>> entity = restTemplate
        .exchange(studentsUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Student>>() {
        });
    List<Student> students = entity.getBody();
    System.out.println(restTemplate.getOAuth2ClientContext().getAccessToken());
    return students;
  }

  public void updateStudent(final Student student) {
    HttpEntity<Student> request = new HttpEntity<>(student);
    ResponseEntity<Void> entity = restTemplate
        .exchange(studentsUrl + student.getId(), HttpMethod.PUT,
            request, Void.class);
  }

}
