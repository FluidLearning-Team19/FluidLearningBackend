package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Note;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.NoteDto;
import com.uiktp.finki.ukim.fluidlearning.Service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(value = "*")
public class NoteRestController {
    private final ModelMapper modelMapper;

    private final NoteService noteService;

    public NoteRestController(ModelMapper modelMapper, NoteService noteService) {
        this.modelMapper = modelMapper;
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Integer id) {
        Note note = this.noteService.getNoteById(id);

        NoteDto noteDto = modelMapper.map(note, NoteDto.class);

        return ResponseEntity.ok().body(noteDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<NoteDto>> getUserNotesById(@PathVariable Integer id) {
        List<Note> note = this.noteService.getNotesByUser(id);

        List<NoteDto> noteDtos = note.stream()
                .map(s -> modelMapper.map(s, NoteDto.class))
                .toList();

        return ResponseEntity.ok().body(noteDtos);
    }

    @PostMapping
    public ResponseEntity<NoteDto> createPost(@RequestBody NoteDto NoteDto) {

        Note noteToAdd = modelMapper.map(NoteDto, Note.class);

        Note note = noteService.createNote(noteToAdd);

        NoteDto noteResponse = modelMapper.map(note, NoteDto.class);

        return new ResponseEntity<>(noteResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDto> updatePost(@PathVariable int id, @RequestBody NoteDto noteDto) {

        Note noteToUpdate = modelMapper.map(noteDto, Note.class);

        Note note = noteService.updateNote(id, noteToUpdate);

        NoteDto noteResponse = modelMapper.map(note, NoteDto.class);

        return ResponseEntity.ok().body(noteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>("Note Deleted", HttpStatus.OK);
    }
}
