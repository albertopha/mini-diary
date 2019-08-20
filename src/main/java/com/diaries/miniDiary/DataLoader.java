package com.diaries.miniDiary;

import com.diaries.miniDiary.model.Note;
import com.diaries.miniDiary.model.Notebook;
import com.diaries.miniDiary.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

  private NoteRepository noteRepository;

  @Autowired
  public DataLoader(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Notebook notebook = new Notebook();
    notebook.setName("notebook#1");
    notebook.setUser(null);
    notebook.setPlaylists(new ArrayList<>());
    notebook.setDateCreated("2038-01-19 03:14:07");
    notebook.setBookmarks(new ArrayList<>());

    Note note = new Note();
    note.setName("note#1");
    note.setContent("first_note");
    note.setDateCreated("2038-01-19 03:14:07");
    note.setNotebook(notebook);
    note.setBookmark(null);

    noteRepository.save(note);
  }
}
