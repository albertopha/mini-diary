package com.diaries.miniDiary.controller;

import com.diaries.miniDiary.model.Note;
import com.diaries.miniDiary.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/notes")
public class NoteController {

  @Autowired
  private NoteService noteService;

  @GetMapping("")
  public List<Note> getAllNotes() {
    return noteService.getAllNotes();
  }

  @GetMapping("/notebooks/{notebookId}")
  public List<Note> getNotesByNotebookId(@PathVariable("notebookId") Long notebookId) {
    return noteService.getNotesByNotebookId(notebookId);
  }
}
