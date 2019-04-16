package com.diaries.miniDiary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bookmark")
public class Bookmark {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Date dateCreated;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "note_id")
  private Note note;

  @ManyToOne(fetch = FetchType.LAZY)
  private Notebook notebook;

  public Bookmark() {}

  public Bookmark(String name, Date date) {
    this.name = name;
    this.dateCreated = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Note getNote() {
    return note;
  }

  public void setNote(Note note) {
    this.note = note;
  }

  public Notebook getNotebook() {
    return notebook;
  }

  public void setNotebook(Notebook notebook) {
    this.notebook = notebook;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bookmark bookmark = (Bookmark) o;
    return Objects.equals(id, bookmark.id) &&
            Objects.equals(name, bookmark.name) &&
            Objects.equals(dateCreated, bookmark.dateCreated) &&
            Objects.equals(note, bookmark.note) &&
            Objects.equals(notebook, bookmark.notebook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, dateCreated, note, notebook);
  }

  @Override
  public String toString() {
    return "Bookmark{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateCreated=" + dateCreated +
            ", note=" + note +
            ", notebook=" + notebook +
            '}';
  }
}
