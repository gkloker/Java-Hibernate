package com.mycompany.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Course implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_course")
  private int idCourse;

  private String name;
  private Double price;

  @OneToMany(mappedBy = "course")
  private List<Assignment> assignments;

  public Course() {}

  public Course(int idCourse) {
    this.idCourse = idCourse;
  }

  public int getIdCourse() {
    return idCourse;
  }

  public void setIdCourse(int idCourse) {
    this.idCourse = idCourse;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public void setAssignments(List<Assignment> assignments) {
    this.assignments = assignments;
  }

  @Override
  public String toString() {
    return "Course{" +
      "idCourse=" + idCourse +
      ", name='" + name + '\'' +
      ", price=" + price +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return idCourse == course.idCourse;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCourse);
  }
}
