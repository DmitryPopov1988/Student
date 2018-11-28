package rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id", scope = Student.class)
public final class Student {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "first_name")
  private String name;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "student_group")
  private short group;
  private String faculty;
  private int age;
  @Lob
  @Basic(optional = false)
  private byte[] image;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
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
