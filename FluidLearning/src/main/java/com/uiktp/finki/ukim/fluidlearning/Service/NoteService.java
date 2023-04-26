package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Note;

import java.util.List;

public interface NoteService {

    Note getNoteById(int noteId);

    Note createNote(Note note);

    Note updateNote(int noteId, Note note);

    void deleteNote(int noteId);

    List<Note> getNotesByUser(int userId);
}
