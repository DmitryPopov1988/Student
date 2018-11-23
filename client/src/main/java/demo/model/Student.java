package demo.model;

import java.util.List;

public class Student {

  private long id;
  private String name;
  private int age;
  private List<Object> subjects;

  public Student() { }

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

  public List<Object> getSubjects() {
    return subjects;
  }

  public void setSubjects(final List<Object> subjects) {
    this.subjects = subjects;
  }

}
