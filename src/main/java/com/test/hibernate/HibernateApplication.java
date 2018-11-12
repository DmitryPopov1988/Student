package com.test.hibernate;

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
  }

}
