package com.diaries.miniDiary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "note")
public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Date dateCreated;
  private String content; //TODO: check if string is in html format

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "notebook_id")
  private Notebook notebook;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "playlist_id")
  private Playlist playlist;

  @OneToOne(mappedBy = "note")
  private Bookmark bookmark;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Notebook getNotebook() {
    return notebook;
  }

  public void setNotebook(Notebook notebook) {
    this.notebook = notebook;
  }

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public Bookmark getBookmark() {
    return bookmark;
  }

  public void setBookmark(Bookmark bookmark) {
    this.bookmark = bookmark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Note note = (Note) o;
    return Objects.equals(id, note.id) &&
            Objects.equals(name, note.name) &&
            Objects.equals(dateCreated, note.dateCreated) &&
            Objects.equals(content, note.content) &&
            Objects.equals(notebook, note.notebook) &&
            Objects.equals(playlist, note.playlist) &&
            Objects.equals(bookmark, note.bookmark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, dateCreated, content, notebook, playlist, bookmark);
  }

  @Override
  public String toString() {
    return "Note{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dateCreated=" + dateCreated +
            ", content='" + content + '\'' +
            ", notebook=" + notebook +
            ", playlist=" + playlist +
            ", bookmark=" + bookmark +
            '}';
  }
}
