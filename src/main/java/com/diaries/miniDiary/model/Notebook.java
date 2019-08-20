package com.diaries.miniDiary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "notebooks")
public class Notebook {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;
  private String dateCreated;

  @OneToMany(mappedBy = "notebook")
  @JsonIgnore
  private List<Note> notes;

  @OneToMany(mappedBy = "notebook")
  @JsonIgnore
  private List<Bookmark> bookmarks;

  @OneToMany(mappedBy = "notebook")
  @JsonIgnore
  private List<Playlist> playlists;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

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

  public String getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  public List<Bookmark> getBookmarks() {
    return bookmarks;
  }

  public void setBookmarks(List<Bookmark> bookmarks) {
    this.bookmarks = bookmarks;
  }

  public List<Playlist> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(List<Playlist> playlists) {
    this.playlists = playlists;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Notebook notebook = (Notebook) o;
    return Objects.equals(id, notebook.id) &&
            Objects.equals(name, notebook.name) &&
            Objects.equals(dateCreated, notebook.dateCreated) &&
            Objects.equals(notes, notebook.notes) &&
            Objects.equals(bookmarks, notebook.bookmarks) &&
            Objects.equals(playlists, notebook.playlists) &&
            Objects.equals(user, notebook.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, dateCreated, notes, bookmarks, playlists, user);
  }

  @Override
  public String toString() {
    return "Notebook{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateCreated=" + dateCreated +
            ", notes=" + notes +
            ", bookmarks=" + bookmarks +
            ", playlists=" + playlists +
            ", user=" + user +
            '}';
  }
}
