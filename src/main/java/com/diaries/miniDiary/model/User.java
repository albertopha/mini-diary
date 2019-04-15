package com.diaries.miniDiary.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
  @Id
  private String id;

  @NotNull
  @Column
  private String name;

  @Column
  private String password;

  @Email
  @Column
  private String email;

  @OneToMany(mappedBy = "notebook")
  private List<Notebook> notebooks;

  public User() {}

  public User(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Notebook> getNotebooks() {
    return notebooks;
  }

  public void setNotebooks(List<Notebook> notebooks) {
    this.notebooks = notebooks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects.equals(password, user.password) &&
            Objects.equals(email, user.email) &&
            Objects.equals(notebooks, user.notebooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password, email, notebooks);
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", notebooks=" + notebooks +
            '}';
  }
}
