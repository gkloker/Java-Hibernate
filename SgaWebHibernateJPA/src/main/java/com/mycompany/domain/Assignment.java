package com.mycompany.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Assignment implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_assignment")
  private int idAssignment;

  private String turn;

  //          ref: table assignment           ref: table student
  @JoinColumn(name = "id_student", referencedColumnName = "id_student")
  @ManyToOne
  private Student student;

  //          ref: table assignment           ref: table course
  @JoinColumn(name = "id_course", referencedColumnName = "id_course")
  @ManyToOne
  private Course course;

  public Assignment() {}

  public Assignment(int idAssignment) {
    this.idAssignment = idAssignment;
  }

  public int getIdAssignment() {
    return idAssignment;
  }

  public void setIdAssignment(int idAssignment) {
    this.idAssignment = idAssignment;
  }

  public String getTurn() {
    return turn;
  }

  public void setTurn(String turn) {
    this.turn = turn;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Assignment{" +
      "idAssignment=" + idAssignment +
      ", turn='" + turn + '\'' +
      ", student=" + student +
      ", course=" + course +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Assignment that = (Assignment) o;
    return idAssignment == that.idAssignment;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAssignment);
  }
}
