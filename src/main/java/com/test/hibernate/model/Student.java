package com.test.hibernate.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public final class Student {

  @Id
  @GeneratedValue
  @Column(name = "student_id")
  private long id;
  private String name;
  private int age;
  @OneToMany(mappedBy = "student")
  private List<Subject> subjects;

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

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(final List<Subject> subjects) {
    this.subjects = subjects;
  }

}
