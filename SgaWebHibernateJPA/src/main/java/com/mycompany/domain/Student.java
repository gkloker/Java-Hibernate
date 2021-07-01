package com.mycompany.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Student implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_student")
  private int idStudent;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  //          ref: table student           ref: table address
  @JoinColumn(name = "id_address", referencedColumnName = "id_address")
  @ManyToOne(cascade = CascadeType.ALL)
  private Address address;

  //          ref: table student           ref: table contact
  @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
  @ManyToOne(cascade = CascadeType.ALL)
  private Contact contact;

  @OneToMany(mappedBy = "student")
  private List<Assignment> assignments;

  public Student() {}

  public Student(int idStudent) {
    this.idStudent = idStudent;
  }

  public int getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(int idStudent) {
    this.idStudent = idStudent;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public void setAssignments(List<Assignment> assignments) {
    this.assignments = assignments;
  }

  @Override
  public String toString() {
    return "Student{" +
      "idStudent=" + idStudent +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", address=" + address +
      ", contact=" + contact +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return idStudent == student.idStudent;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idStudent);
  }
}
