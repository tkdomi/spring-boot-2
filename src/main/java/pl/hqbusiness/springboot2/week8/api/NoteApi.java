package pl.hqbusiness.springboot2.week8.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hqbusiness.springboot2.week8.dao.NoteRepo;
import pl.hqbusiness.springboot2.week8.model.Note;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class NoteApi {

  private NoteRepo noteRepo;

  public NoteApi(NoteRepo noteRepo) {
    this.noteRepo = noteRepo;
  }

  @GetMapping
  public ResponseEntity<List<Note>> getNotes() {
    return ResponseEntity.ok(noteRepo.findAll());
  }

  @GetMapping(path="/{id}")
  public ResponseEntity<Note> getNote(@PathVariable Long id) {
    Optional<Note> note = noteRepo.findById(id);
    return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
  }

  @PostMapping
  public ResponseEntity<Note> addNote(@RequestBody Note note) {
    return ResponseEntity.ok(noteRepo.save(note));
  }

  @PutMapping
  public ResponseEntity<Note> editNote(@RequestBody Note note) {
    return ResponseEntity.ok(noteRepo.save(note));
  }

  @DeleteMapping(path="/{id}")
  public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
    noteRepo.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
