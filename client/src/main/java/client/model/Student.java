package client.model;

import java.util.List;

public final class Student {

  private long id;
  private String name;
  private String lastName;
  private short group;
  private String faculty;
  private int age;
  private byte[] image;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public short getGroup() {
    return group;
  }

  public void setGroup(final short group) {
    this.group = group;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(final String faculty) {
    this.faculty = faculty;
  }

  public int getAge() {
    return age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(final byte[] image) {
    this.image = image;
  }

  public List<Object> getSubjects() {
    return subjects;
  }

  public void setSubjects(final List<Object> subjects) {
    this.subjects = subjects;
  }
}
