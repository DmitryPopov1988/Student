package rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public final class Student {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  @Column(name = "student_group")
  private short group;
  private String faculty;
  private int age;
  @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
  private List<Subject> subjects;
  @OneToOne(mappedBy = "student", fetch = FetchType.EAGER)
  private User user;

  public Student() { }

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

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(final List<Subject> subjectList) {
    this.subjects = subjectList;
  }

  public User getUser() {
    return user;
  }

  public void setUser(final User user) {
    this.user = user;
  }
}
