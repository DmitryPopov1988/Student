package com.test.hibernate;

import com.test.hibernate.model.Student;
import com.test.hibernate.model.Subject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.hibernate"})
@EnableJpaAuditing
public class HibernateApplication
    implements CommandLineRunner {

  @Autowired
  private SessionFactory sessionFactory;

  public static void main(final String[] args) {
    SpringApplication.run(HibernateApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Subject subject = new Subject("TEST 100");
    Subject subject1 = new Subject("TEST 200");
    List<Subject> subjectList = Stream.of(subject, subject1)
        .collect(Collectors.toList());
    Student student = new Student("Barbara Streisend", 80);
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    student.setSubjects(subjectList);
    subject.setStudent(student);
    subject1.setStudent(student);
    session.save(student);
    session.save(subject1);
    session.save(subject);
    session.getTransaction().commit();
    System.out.println("Commit");
  }
}


