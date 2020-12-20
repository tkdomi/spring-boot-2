package pl.hqbusiness.springboot2.week8.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.hqbusiness.springboot2.week8.dao.NoteRepo;
import pl.hqbusiness.springboot2.week8.model.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class NoteApiTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private NoteRepo noteRepo;

  @Test
  void should_get_all_notes() throws Exception {
    List<Note> expectedNotes = getTestNotes();

    Mockito.when(noteRepo.findAll()).thenReturn(expectedNotes);

    mockMvc.perform(get("/api/v1/notes"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(expectedNotes.size())));
  }

  @Test
  void should_get_note() throws Exception {
    Note note = new Note("Test note", "Note text");
    note.setId(1L);

    given(noteRepo.findById(any(Long.class))).willReturn(Optional.of(note));

    mockMvc.perform(get("/api/v1/notes/{id}", note.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(note.getId()))
        .andExpect(jsonPath("$.title").value(note.getTitle()));
  }

  @Test
  void should_add_new_note() throws Exception {
    Note note = new Note("Title", "Content");
    note.setId(1L);

    given(noteRepo.save(any(Note.class))).willReturn(note);

    mockMvc.perform(post("/api/v1/notes")
        .content(asJsonString(note))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.title").value(note.getTitle()))
        .andExpect(jsonPath("$.text").value(note.getText()));
  }

  @Test
  void should_update_note() throws Exception {
    Note note = new Note("Title", "Content");
    note.setId(1L);

    given(noteRepo.save(any(Note.class))).willReturn(note);

    mockMvc.perform(put("/api/v1/notes")
        .content(asJsonString(note))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.title").value(note.getTitle()))
        .andExpect(jsonPath("$.text").value(note.getText()));
  }

  @Test
  void should_delete_note() throws Exception {
    Long id = 1L;

    mockMvc.perform(delete("/api/v1/notes/{id}", id))
        .andExpect(status().isOk());
  }

  private List<Note> getTestNotes(){

    Note n1 = new Note("Sample Note", "Note text");
    n1.setId(1L);

    Note n2 = new Note("Test Note", "Test note text");
    n2.setId(2L);

    return new ArrayList<>(Arrays.asList(n1, n2));
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
