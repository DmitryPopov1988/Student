package demo.model;

import java.util.List;

public class Subject {

  private long id;
  private String nameSubject;
  private List<Student> students;

  public Subject() { }

  public Subject(final long id, final String nameSubject) {
    this.id = id;
    this.nameSubject = nameSubject;
  }

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
