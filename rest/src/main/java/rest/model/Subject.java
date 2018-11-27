package rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public final class Subject {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "name_subject")
  private String nameSubject;
  @ManyToMany(cascade = CascadeType.REFRESH)
  private List<Student> students;

  public Subject() { }

  public Subject(final String nameSubject) {
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
