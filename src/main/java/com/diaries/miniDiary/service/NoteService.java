package com.diaries.miniDiary.service;

import com.diaries.miniDiary.model.Note;
import com.diaries.miniDiary.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;

  public List<Note> getAllNotes() {
    return noteRepository.findAll();
  }

  public List<Note> getNotesByNotebookId(Long notebookId) {
    return noteRepository.findNotesByNotebookId(notebookId);
  }
}
