package client.model;

import java.util.List;

public final class Subject {

  private long id;
  private String nameSubject;
  private List<Student> students;

  public Subject() { }

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getNameSubject() {
    return nameSubject;
  }

  public void setNameSubject(final String nameSubject) {
    this.nameSubject = nameSubject;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(final List<Student> students) {
    this.students = students;
  }

}
