package com.diaries.miniDiary.repository;

import com.diaries.miniDiary.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  Note save(Note note);
  List<Note> findAll();
  List<Note> findNotesByNotebookId(Long id);
  List<Note> findNotesByPlaylistId(Long id);
  Note findNoteById(Long id);
  Note findNoteByBookmarkId(Long id);
}
