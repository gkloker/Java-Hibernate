package com.mycompany.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_address")
  private int idAddress;

  private String street;

  @Column(name = "num_street")
  private String numStreet;

  private String country;

  public Address() {}

  public Address(int idAddress) {
    this.idAddress = idAddress;
  }

  public int getIdAddress() {
    return idAddress;
  }

  public void setIdAddress(int idAddress) {
    this.idAddress = idAddress;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumStreet() {
    return numStreet;
  }

  public void setNumStreet(String numStreet) {
    this.numStreet = numStreet;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address{" +
            "idAddress=" + idAddress +
            ", street='" + street + '\'' +
            ", numStreet='" + numStreet + '\'' +
            ", country='" + country + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return idAddress == address.idAddress;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAddress);
  }
}
