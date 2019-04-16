package com.diaries.miniDiary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "playlist")
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Date dateCreated;

  @OneToMany(mappedBy = "playlist")
  private List<Note> notes;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "notebook_id")
  private Notebook notebook;

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

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
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
    Playlist playlist = (Playlist) o;
    return Objects.equals(id, playlist.id) &&
            Objects.equals(name, playlist.name) &&
            Objects.equals(dateCreated, playlist.dateCreated) &&
            Objects.equals(notes, playlist.notes) &&
            Objects.equals(notebook, playlist.notebook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, dateCreated, notes, notebook);
  }

  @Override
  public String toString() {
    return "Playlist{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateCreated=" + dateCreated +
            ", notes=" + notes +
            ", notebook=" + notebook +
            '}';
  }
}
