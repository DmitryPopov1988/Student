package com.test.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public final class Student {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private int age;

  public Student() { }

  public Student(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public Student(final long id, final String name, final int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(final int age) {
    this.age = age;
  }
}
