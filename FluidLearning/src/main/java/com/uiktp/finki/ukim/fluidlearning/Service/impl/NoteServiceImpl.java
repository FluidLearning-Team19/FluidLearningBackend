package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Note;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidBadRequestException;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.NoteRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UsersRepository usersRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UsersRepository usersRepository) {
        this.noteRepository = noteRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Note getNoteById(int noteId) {
        return this.noteRepository.findById(noteId).orElseThrow(() -> new FluidNotFoundException("Could not find Note with Id:" + noteId));
    }

    @Override
    public Note createNote(Note note) {
        if (usersRepository.existsById(note.getUser().getId()))
        {
            return this.noteRepository.save(note);
        }
        else
        {
            throw new FluidBadRequestException("Cannot create a note with a nonexistent user");
        }
    }

    @Override
    public Note updateNote(int noteId, Note note) {
        if (usersRepository.existsById(note.getUser().getId()))
        {
            Note noteToUpdate = this.noteRepository.findById(noteId).orElseThrow(() -> new FluidNotFoundException("Could not find Note with Id:" + noteId));
            noteToUpdate.setContent(note.getContent());
            return this.noteRepository.save(noteToUpdate);
        }
        else
        {
            throw new FluidBadRequestException("Cannot update a note with a nonexistent user");
        }
    }

    @Override
    public void deleteNote(int noteId) {
        Note noteToDelete = this.noteRepository.findById(noteId).orElseThrow(() -> new FluidNotFoundException("Could not find Note with Id:" + noteId));

        this.noteRepository.delete(noteToDelete);
    }

    @Override
    public List<Note> getNotesByUser(int userId) {
        return this.noteRepository.findAll().stream()
                .filter(e -> e.getUser().getId() == userId)
                .collect(Collectors.toList());
    }
}
