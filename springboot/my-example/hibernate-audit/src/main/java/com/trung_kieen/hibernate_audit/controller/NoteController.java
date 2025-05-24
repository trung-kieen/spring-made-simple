package com.trung_kieen.hibernate_audit.controller;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.trung_kieen.hibernate_audit.entity.Note;
import com.trung_kieen.hibernate_audit.exception.ResourceNoteFoundException;
import com.trung_kieen.hibernate_audit.payload.NoteRequest;
import com.trung_kieen.hibernate_audit.repository.NoteRepository;

/**
 * NoteController
 */
@RestController
@RequestMapping("/api/note/")
public class NoteController {

  @Autowired
  private NoteRepository noteRepository;

  @GetMapping
  public ResponseEntity<?> getAll() {
    var notes = noteRepository.findAll();
    System.out.println(notes);
    if (notes.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(notes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable("id") Long id) {
    Note note = noteRepository.findById(id)
        .orElseThrow(() -> new ResourceNoteFoundException("note", "id", id));
    return ResponseEntity.ok(note);
  }

  @PostMapping("/")
  public ResponseEntity<?> create(@RequestBody NoteRequest noteDetails) {

    // return "IT IS POST MEHTOD ";
    var note = new Note(noteDetails.title(), noteDetails.content());
    return ResponseEntity.ok(noteRepository.save(note));
  }

  @PutMapping("/")
  public void update(@RequestBody Note noteDetails) {
    var note = noteRepository.findById(noteDetails.getId())
        .orElseThrow(() -> new ResourceNoteFoundException("note", "id", noteDetails.getId()));
    note.setContent(noteDetails.getContent());
    note.setTitle(noteDetails.getTitle());
    noteRepository.save(note);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    var note = noteRepository.findById(id)
        .orElseThrow(() -> new ResourceNoteFoundException("note", "id", id));
    noteRepository.delete(note);
    return ResponseEntity.ok("Note have been deleted");
  }

}
