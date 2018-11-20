package com.test.hibernate;

import com.test.hibernate.config.HibernateAnnotationUtil;
import com.test.hibernate.model.Student;
import com.test.hibernate.model.Subject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.hibernate"})
@EnableJpaAuditing
public class HibernateApplication {

  public static void main(final String[] args) {
    SpringApplication.run(HibernateApplication.class, args);
    Student student = new Student("Test", 50);

    Subject subject1 = new Subject("Math");
    subject1.setStudent(student);
    Subject subject = new Subject("Physic");
    subject.setStudent(student);
    List<Subject> subjects = new ArrayList<>();
    subjects.add(subject1);
    subjects.add(subject);

    student.setSubjects(subjects);


    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    try {
      // Get Session
      sessionFactory = HibernateAnnotationUtil.getSessionFactory();
      session = sessionFactory.getCurrentSession();
      System.out.println("Session created");
      // start transaction
      tx = session.beginTransaction();
      // Save the Model object
      session.save(student);
      session.save(subject1);
      session.save(subject);
      // Commit transaction
      tx.commit();

    } catch (Exception e) {
      System.out.println("Exception occured. " + e.getMessage());
      e.printStackTrace();
    } finally {
      if (!sessionFactory.isClosed()) {
        System.out.println("Closing SessionFactory");
        sessionFactory.close();
      }
    }
  }
}


