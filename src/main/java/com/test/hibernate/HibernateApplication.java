package com.test.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.hibernate"})
public class HibernateApplication {

  public static void main(final String[] args) {
    SpringApplication.run(HibernateApplication.class, args);
  }
}
