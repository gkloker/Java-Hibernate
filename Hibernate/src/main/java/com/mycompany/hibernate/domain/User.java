package com.mycompany.hibernate.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    private int idUser;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{id: " + idUser + ", first_name: " + first_name + ", last_name: " + last_name + ", email: " + email + ", phone: " + phone + "}";
    }

}
