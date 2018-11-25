package demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public final class Student {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private int age;
  @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
  private List<Subject> subjects;

  public Student() { }

  public Student(final String name, final int age) {
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

  public void setSubjects(final List<Subject> subjectList) {
    this.subjects = subjectList;
  }

}
