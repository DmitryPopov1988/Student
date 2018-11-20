package com.test.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public final class Subject {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "name_subject")
  private String nameSubject;
  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

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

  public Student getStudent() {
    return student;
  }

  public void setStudent(final Student student) {
    this.student = student;
  }
}
